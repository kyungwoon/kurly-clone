package com.clone.kurly.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CrawlingController {

    private final TryCrawlingController tryCrawlingController;

    //채소
    @GetMapping("/addproduct/907")
    public void detailArticleVeggie() {
        int[] itemList = {52618, 69371, 30559, 31391, 49920, 58732, 45384, 27320, 31395, 26448, 1385, 27318, 54657, 54660, 26451, 30557, 26449, 49921, 70, 30781, 31100, 63043, 27319, 49246, 49248, 53496, 53330, 36663, 49249, 53497};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 907);
        }
    }
    @GetMapping("/addproduct/908")
    public void detailArticleFruit() {
        int[] itemList = {112260, 31441, 65323, 29438, 31443, 72636, 48934, 89634, 63578, 95355, 95354, 63695, 267, 59321, 29436, 49846, 103984, 113888, 51900, 59632, 10854, 66038, 35693, 59631, 99, 5943, 45660, 63381, 30849, 50309};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 908);
        }
    }
    @GetMapping("/addproduct/909")
    public void detailArticleSeafood() {
        int[] itemList = {41844, 41849, 114910, 62328, 73787, 97959, 1391, 73858, 27202, 50422, 11162, 34124, 70691, 45277, 47711, 4778, 44716, 35000, 62739, 37066, 26587, 112254, 3446, 60769, 8761, 35003, 29610, 44113, 51709, 56554};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 909);
        }
    }
    @GetMapping("/addproduct/910")
    public void detailArticleMeatEgg() {
        int[] itemList = {10943, 103614, 103615, 103616, 103617, 116462, 116500, 56791, 69853, 78347, 51264, 56512, 56790, 29850, 69036, 31086, 36067, 72939, 69067, 56509, 56511, 55620, 29849, 78346, 4951, 27132, 6176, 31421, 97333, 13511};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 910);
        }
    }
    @GetMapping("/addproduct/911")
    public void detailArticleSoup() {
        int[] itemList = {10943, 71658, 71661, 103963, 103964, 105613, 117327, 117328, 117336, 53329, 75513, 50290, 26468, 68232, 88325, 37794, 1673, 71408, 48639, 69951, 52131, 88188, 73787, 68028, 81954, 56344, 53977, 81665, 73094, 70786};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 911);
        }
    }
    @GetMapping("/addproduct/912")
    public void detailArticleSalad() {
        int[] itemList = {31703, 31704, 31706, 78419, 90388, 105527, 116418, 116419, 27449, 66426, 73865, 41697, 60785, 65872, 52644, 1385, 95223, 50290, 51264, 55589, 26771, 50287, 68232, 88325, 37794, 69036, 72794, 2749, 71408, 48186};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 912);
        }
    }
    @GetMapping("/addproduct/913")
    public void detailArticleNoodle() {
        int[] itemList = {52097, 59149, 61980, 6565, 48639, 53977, 44481, 36962, 36150, 52812, 35376, 62021, 68982, 1269, 69965, 6477, 9467, 50925, 48049, 55839, 66881, 44482, 12950, 49787, 343, 68820, 69128, 49453, 60196, 49766};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 913);
        }
    }
    @GetMapping("/addproduct/914")
    public void detailArticleBeverage() {
        int[] itemList = {66941, 61927, 70607, 112536, 12346, 63110, 61930, 385, 10049, 70677, 3192, 58873, 52162, 56621, 54665, 52912, 54605, 54604, 54589, 54548, 54478, 54469, 54383, 54382, 54379, 54343, 54340, 54337, 54334, 54331};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 914);
        }
    }
    @GetMapping("/addproduct/249")
    public void detailArticleSnack() {
        int[] itemList = {48236, 68129, 64194, 6817, 29830, 62022, 49549, 42084, 42105, 12470, 12465, 43436, 11048, 10904, 60494, 13255, 4920, 49988, 49991, 41100, 56654, 26439, 10640, 10641, 40442, 43289, 41103, 55484, 4445, 4442};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 249);
        }
    }

    @GetMapping("/addproduct/915")
    public void detailArticleBakery() {
        int[] itemList = {42529, 65901, 65902, 3291, 1255, 30254, 60864, 60865, 60866, 60867, 60868, 60559, 26619, 55888, 45161, 55631, 54138, 55500, 27999, 55238, 55237, 55232, 55227, 55228, 55222, 55231, 55224, 55223, 55221, 55220};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 915);
        }
    }
    @GetMapping("/addproduct/32")
    public void detailArticleHealthPill() {
        int[] itemList = {114981, 114982, 114983, 114984, 97886, 49159, 73816, 11021, 59298, 100783, 31986, 42152, 59682, 45828, 26039, 61905, 45462, 47787, 97887, 47976, 76547, 61904, 34704, 65570, 34369, 106508, 57627, 61410, 45453, 26292};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 32);
        }
    }
    @GetMapping("/addproduct/251")
    public void detailArticleLiquor() {
        int[] itemList = {113317, 113316, 113315, 113314, 113313, 113311, 113310, 113303, 110336, 110335, 110334, 100854, 100874, 100870, 100861, 100875, 100856, 100903, 100904, 100864, 100865, 100867, 100872, 100873, 100857, 100858, 100859, 100860, 100902, 100863};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 251);
        }
    }
    @GetMapping("/addproduct/918")
    public void detailArticleLiving() {
        int[] itemList = {112692, 112691, 113604, 61286, 74265, 74267, 36174, 99368, 113921, 98911, 94269, 74266, 74264, 90109, 74269, 54216, 61288, 93353, 110504, 32028, 37787, 55212, 113603, 63604, 78195, 100492, 45698, 61199, 40737, 85507};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 918);
        }
    }
    @GetMapping("/addproduct/233")
    public void detailArticleSkincare() {
        int[] itemList = {49665, 67263, 81312, 82029, 34949, 72587, 70195, 57941, 53231, 90095, 71021, 68784, 55372, 71118, 60191, 63595, 68789, 95207, 90333, 53042, 61548, 76024, 60192, 68464, 57217, 63097, 100996, 86593, 112586, 93247};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 233);
        }
    }
    @GetMapping("/addproduct/12")
    public void detailArticleHairBody() {
        int[] itemList = {78443, 105803, 113195, 113196, 113197, 113198, 113199, 117339, 117340, 61659, 13721, 66847, 41824, 104188, 81312, 52760, 41482, 78445, 73203, 7645, 65887, 62634, 66861, 90324, 82029, 26825, 81987, 104187, 62637, 112670};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 12);
        }
    }
    @GetMapping("/addproduct/916")
    public void detailArticleKitchen() {
        int[] itemList = {116351, 109599, 99368, 78475, 56663, 95231, 54216, 37780, 37787, 40084, 59729, 63604, 81200, 66841, 63191, 35669, 12651, 113917, 48296, 81211, 11160, 105549, 106378, 95232, 54214, 97370, 37522, 68995, 64052, 30577};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 916);
        }
    }
    @GetMapping("/addproduct/85")
    public void detailArticleHomeMachine() {
        int[] itemList = {61239, 60808, 69464, 63470, 66427, 56812, 112751, 112658, 60710, 66882, 77690, 57875, 115194, 77687, 52685, 6529, 52858, 93493, 70480, 74287, 93280, 105696, 66428, 50515, 112656, 104072, 115199, 51434, 67966, 110069, 77689};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 85);
        }
    }
    @GetMapping("/addproduct/991")
    public void detailArticleBowWow() {
        int[] itemList = {58932, 38207, 34853, 63614, 51089, 53715, 112145, 106412, 34816, 51088, 60680, 70323, 106669, 70346, 61413, 68484, 37459, 78474, 53724, 71629, 51396, 30939, 66879, 63613, 78473, 60750, 63615, 53998, 68267, 70486, 58958};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 991);
        }
    }
    @GetMapping("/addproduct/919")
    public void detailArticleBabies() {
        int[] itemList = {4424, 11633, 60718, 2718, 32292, 1691, 6482, 7414, 27869, 37066, 4432, 13766, 10142, 61288, 50688, 70028, 12392, 70027, 50691, 30222, 4416, 62459, 97563, 50687, 151, 26232, 62457, 70031, 109981, 30549, 11021};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 919);
        }
    }
    @GetMapping("/addproduct/724")
    public void detailArticleHomeStay() {
        int[] itemList = {115212, 115213, 115214, 66426, 43454, 52922, 2749, 7270, 12569, 69137, 4411, 60559, 63758, 44523, 30877, 48310, 1680, 56046, 4499, 36621, 61105, 5051, 29637, 45206, 32106, 69168, 10721, 48706, 48681, 9371};

        for(int i : itemList){
            tryCrawlingController.TrySaveData(i, 724);
        }
    }
}