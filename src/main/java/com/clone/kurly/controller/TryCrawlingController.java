package com.clone.kurly.controller;

import com.clone.kurly.domain.Product;
import com.clone.kurly.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class TryCrawlingController {
    private final ProductRepository productRepository;


    // 웹사이트에서 내가 발급 받은 토큰으로 https://api.kurly.com/v3/home/products/{productNo}2?&ver=1645240928256 에 GET 요청 날리기
    // 방법 :  intelliJ에서 내부적으로 토큰을 담아서 요청을 보내고 (2) 내 DB에 쌓도록 함

    //크롤링 결과물을 unicode -> 한글로 변환하는 함수
    public String uniToKor(String uni){
        StringBuffer result = new StringBuffer();

        for(int i=0; i<uni.length(); i++){
            if(uni.charAt(i) == '\\' &&  uni.charAt(i+1) == 'u'){
                Character c = (char)Integer.parseInt(uni.substring(i+2, i+6), 16);
                result.append(c);
                i+=5;
            }else{
                result.append(uni.charAt(i));
            }
        }
        return result.toString();
    }

    //마켓컬리 제품 정보 크롤링하기
    public JSONObject TryCrawlingMarketKurly(int productNo) {

        //http request header의 auth token, request url, request method 담기
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjYXJ0X2lkIjoiNjgxNzE5MmUtNzBjYy00ZDU4LWJjMjYtNjJlNzM2MzczMTBiIiwiaXNfZ3Vlc3QiOnRydWUsInV1aWQiOm51bGwsIm1fbm8iOm51bGwsIm1faWQiOm51bGwsImxldmVsIjpudWxsLCJzdWIiOm51bGwsImlzcyI6Imh0dHA6Ly9ta3dlYi5hcGkua3VybHkuc2VydmljZXMvdjMvYXV0aC9ndWVzdCIsImlhdCI6MTY0NTUwNjcyMiwiZXhwIjoxNjQ1NTEwMzIyLCJuYmYiOjE2NDU1MDY3MjIsImp0aSI6Ikdnak5Od1I0RHFzMDhjS3MifQ.P_6oqOPbbp-K-rf2kmLD5YIMkIK4tTbWcp-QwJ5m_LU";
//            String reqURL = "https://api.kurly.com/v3/home/products/4962?&ver=1645240928256";
        String reqURL = "https://api.kurly.com/v3/home/products/" + productNo + "?&ver=1645240928256";

        JSONObject rawData = null;
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Bearer " + token); //전송할 header 작성, access_token전송

            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            //한글 유니코드 변환
            String realResult = uniToKor(result);

            System.out.println("response body : " + realResult);

            //JSON parse 후 필요한 결과 빼오기
            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(realResult);
            String rawObjecttoString = jsonObject.toString();
            System.out.println(rawObjecttoString);

            //data value 값 가져오기
            rawData = (JSONObject) jsonObject.get("data");

            //db에 넣을 값들만 빼오기



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return rawData;
    }

    public Product TryMakeProduct(int productNo){

        JSONObject rawData = TryCrawlingMarketKurly(productNo);

        String no = (String) rawData.get("no");
        String name = (String) rawData.get("name");
        String shortDescription = (String) rawData.get("short_description");

        JSONObject tags = (JSONObject) rawData.get("tags");
        boolean isKurlyOnly = false;
        JSONArray tagnames = (JSONArray) tags.get("names");
        if(tagnames.size()==0){
            isKurlyOnly = false;
        } else{
            if(tagnames.get(0).equals("Kurly Only")) {isKurlyOnly = true;}
        }

        boolean isSales = (boolean) rawData.get("is_sales");
        String unitText = (String) rawData.get("unit_text");
        String weight = (String) rawData.get("weight");
        String contactAnt = (String) rawData.get("contactant");

        JSONArray guidesArray = (JSONArray) rawData.get("guides");
        String guides = "";

        //data가 너무 긴 경우 오류나기 때문에 하나만 뽑도록 하겠음
        if(guidesArray.size()==0){
            guides ="";
        } else{ guides = (String) guidesArray.get(0);}

        String deliveryTimeType = (String) rawData.get("delivery_time_type_text");
        String packingType = (String) rawData.get("packing_type_text");

        Long deliveryType = (Long) rawData.get("delivery_type");
        Long deliveryPrice = (Long) rawData.get("delivery_price");

        boolean isSoldOut = (boolean) rawData.get("is_sold_out");
        Long originalPrice = (Long) rawData.get("original_price");
        Long discountedPrice = (Long) rawData.get("discounted_price");
        Long discountPercent = (Long) rawData.get("discount_percent");

        String mainImageUrl = (String) rawData.get("main_image_url");
        String listImageUrl = (String) rawData.get("list_image_url");
        String detailImageUrl = (String) rawData.get("detail_image_url");

        Product product = new Product();

        product.setCategoryNo(100);
        product.setCategoryName("미분류");
        product.setKurlyOnly(isKurlyOnly);
        product.setNo(no);
        product.setName(name);
        product.setShortDescription(shortDescription);
        product.setSales(isSales); //근데 이건 왜 setIsSales가 아닌거? 이따 찾아보기
        product.setUnitText(unitText);
        product.setWeight(weight);
        product.setContactAnt(contactAnt);
        product.setGuides(guides);
        product.setDeliveryTimeType(deliveryTimeType);
        product.setPackingType(packingType);
        product.setDeliveryType(deliveryType);
        product.setDeliveryPrice(deliveryPrice);
        product.setSoldOut(isSoldOut);
        product.setOriginalPrice(originalPrice);
        product.setDiscountedPrice(discountedPrice);
        product.setDiscountPercent(discountPercent);
        product.setMainImageUrl(mainImageUrl);
        product.setListImageUrl(listImageUrl);
        product.setDetailImageUrl(detailImageUrl);


        return product;
    }

    public void TrySaveData(int productNo, int categoryNo){
        Product product = TryMakeProduct(productNo);
        product.setCategoryNo(categoryNo);

        String categoryName = "";
        switch(categoryNo){
            case 907: categoryName = "채소";
                break;
            case 908: categoryName = "과일·견과·쌀";
                break;
            case 909: categoryName = "수산·해산·건어물";
                break;
            case 910: categoryName = "정육·계란";
                break;
            case 911: categoryName = "국·반찬·메인요리";
                break;
            case 912: categoryName = "샐러드·간편식";
                break;
            case 913: categoryName = "면·양념·오일";
                break;
            case 914: categoryName = "생수·음료·우유·커피";
                break;
            case 249: categoryName = "간식·과자·떡";
                break;
            case 915: categoryName = "베이커리·치즈·델리";
                break;
            case 32: categoryName = "건강식품";
                break;
            case 251: categoryName = "전통주";
                break;
            case 918: categoryName = "생활용품·리빙·캠핑";
                break;
            case 233: categoryName = "스킨케어·메이크업";
                break;
            case 12: categoryName = "헤어·바디·구강";
                break;
            case 916: categoryName = "주방용품";
                break;
            case 85: categoryName = "가전제품";
                break;
            case 991: categoryName = "반려동물";
                break;
            case 919: categoryName = "베이비·키즈·완구";
                break;
            case 724: categoryName = "홈캉스";
                break;
        }

        product.setCategoryName(categoryName);
        productRepository.save(product);
    }

}