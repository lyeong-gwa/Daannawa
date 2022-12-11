package com.deadlock.firstapp.part;

import com.deadlock.firstapp.data_ctrl.DBReader;

public class RecommendPart {
    private String use;
    private String use_detail;
    private DBReader dbReader;

    private Selectpart selectpart;

    public void get_list(String use, String use_detail, Selectpart selectpart) {
        this.use = use;
        this.use_detail = use_detail;
        this.selectpart = selectpart;

        String[] office = new String[] {
                "인텔 코어i3-10세대 10100F (코멧레이크S)",
                "",
                "ASUS PRIME H410M-K 인텍앤컴퍼니",
                "GeIL DDR4-2666 CL19 PRISTINE 8GB", // *2
                "",
                "Western Digital WD Blue 3D SSD 250GB",
                "잘만 MegaMax 500W 80PLUS STANDARD",
                "마이크로닉스 오피스"
        };

        String[] design_1 = new String[] {
                "AMD 라이젠3 PRO 4350G (르누아르)",
                "",
                "MSI A320M-A PRO",
                "GeIL DDR4-2666 CL19 PRISTINE 8GB", // *2
                "",
                "Western Digital WD Blue 3D SSD 250GB",
                "잘만 MegaMax 500W 80PLUS STANDARD",
                "3RSYS J210 해머"
        };

        String[] design_2 = new String[] {
                "AMD 라이젠5-3세대 3500 (마티스)",
                "써모랩 TRINITY 6.0",
                "MSI A320M-A PRO",
                "삼성전자 DDR4-3200 8GB", // *2
                "COLORFUL 지포스 GTX 1650 토마호크 EX D6 4GB",
                "Western Digital WD Blue 3D SSD 250GB",
                "잘만 MegaMax 500W 80PLUS STANDARD",
                "3RSYS J210 해머"
        };

        String[] design_3 = new String[] {
                "AMD 라이젠5-3세대 3600XT (마티스)",
                "써모랩 TRINITY 6.0",
                "ASRock B450M-HDV R4.0 에즈윈",
                "삼성전자 DDR4-3200 8GB", // *2
                "이엠텍 지포스 GTX 1650 SUPER STORM X NANO OC D6 4GB",
                "Western Digital WD Blue 3D SSD 250GB",
                "잘만 MegaMax 500W 80PLUS STANDARD",
                "마이크로닉스 GH1-MESH 강화유리"
        };

        String[] design_4 = new String[] {
                "AMD 라이젠5-4세대 5600X (버미어)",
                "DEEPCOOL GAMMAXX 400 V2",
                "ASRock B450M-HDV R4.0 에즈윈",
                "삼성전자 DDR4-3200 8GB", // *4
                "COLORFUL 지포스 GTX 1660 토마호크 D5 6GB",
                "Western Digital WD BLACK SN750 M.2 NVMe 250GB",
                "잘만 GigaMax 550W 80PLUS Bronze 230V EU",
                "ABKO SUITMASTER 290G 위저드 강화유리"
        };

        String[] design_5 = new String[] {
                "AMD 라이젠5-4세대 5600X (버미어)",
                "EVGA CLC 240 Liquid",
                "ASRock B450M-HDV R4.0 에즈윈",
                "삼성전자 DDR4-3200 8GB", // *4
                "COLORFUL 지포스 GTX 1660 토마호크 D5 6GB",
                "Western Digital WD BLACK SN750 M.2 NVMe 250GB",
                "잘만 GigaMax 550W 80PLUS Bronze 230V EU",
                "ABKO SUITMASTER 290G 위저드 강화유리"
        };

        String[] game_1 = new String[] {
                "AMD 라이젠3 PRO 4350G (르누아르)",
                "",
                "MSI A520M PRO",
                "삼성전자 DDR4-3200 8GB",
                "",
                "Western Digital WD Blue 3D SSD 250GB",
                "잘만 MegaMax 500W 80PLUS STANDARD",
                "3RSYS J210 해머"
        };

        String[] game_2 = new String[] {
                "AMD 라이젠5-3세대 3500X (마티스)",
                "",
                "ASRock B450M-HDV R4.0 에즈윈",
                "삼성전자 DDR4-3200 8GB", // *2
                "COLORFUL 지포스 GTX 1650 토마호크 EX D6 4GB",
                "Western Digital WD Blue 3D SSD 250GB",
                "FSP HYPER K 500W 80PLUS Standard 230V EU",
                "3RSYS J210 해머"
        };

        String[] game_3 = new String[] {
                "AMD 라이젠5-3세대 3500X (마티스)",
                "DEEPCOOL GAMMAXX 400 V2",
                "ASRock B450M-HDV R4.0 에즈윈",
                "삼성전자 DDR4-3200 8GB", // *2
                "이엠텍 지포스 GTX 1650 SUPER STORM X NANO OC D6 4GB",
                "마이크론 Crucial MX500 대원CTS 500GB",
                "FSP HYPER K 500W 80PLUS Standard 230V EU",
                "마이크로닉스 GH1-MESH 강화유리"
        };

        String[] game_4 = new String[] {
                "AMD 라이젠5-3세대 3600X (마티스)",
                "DEEPCOOL GAMMAXX 400 V2",
                "MSI MAG B450M 박격포 맥스",
                "삼성전자 DDR4-3200 8GB", // *2
                "COLORFUL 지포스 GTX 1660 Ti 토마호크 D6 6GB",
                "마이크론 Crucial MX500 대원CTS 500GB",
                "FSP HYPER K 500W 80PLUS Standard 230V EU",
                "3RSYS L530 강화유리"
        };

        String[] game_5 = new String[] {
                "AMD 라이젠5-3세대 3600X (마티스)",
                "Thermalright Le GRAND MACHO RT",
                "MSI MAG B450M 박격포 맥스",
                "삼성전자 DDR4-3200 8GB", // *2
                "이엠텍 지포스 RTX 2070 SUPER GAMER OC D6 8GB",
                "마이크론 Crucial MX500 대원CTS 500GB",
                "FSP HYPER K 600W 80PLUS Standard 230V EU",
                "3RSYS L530 강화유리"
        };

        String[] game_6 = new String[] {
                "AMD 라이젠5-3세대 3600X (마티스)",
                "EVGA CLC 240 Liquid",
                "MSI MAG B450M 박격포 맥스",
                "삼성전자 DDR4-3200 8GB", // *2
                "ZOTAC GAMING 지포스 RTX 3070 Edge OC D6 8GB TWIN",
                "마이크론 Crucial MX500 대원CTS 500GB",
                "FSP HYPER K 600W 80PLUS Standard 230V EU",
                "Antec P101 SILENT"
        };

        if(use.equals("사무용")) {
            setList(office, 1);
        } else if(use.equals("디자인용")) {
            if(use_detail.equals("간단한 디자인_30만원대")) {
                setList(design_1, 2);
            } else if(use_detail.equals("간단한 포토샵_50만원대")) {
                setList(design_2, 2);
            } else if(use_detail.equals("간단한 포토샵_70만원대")) {
                setList(design_3, 2);
            } else if(use_detail.equals("전문적인 포토샵_100만원대")) {
                setList(design_4, 4);
            } else if(use_detail.equals("전문적인 포토샵_110만원대")) {
                setList(design_5, 4);
            }
        } else if(use.equals("게임용")) {
            if(use_detail.equals("롤_30만원대")) {
                setList(game_1, 1);
            } else if(use_detail.equals("오버워치_50만원대")) {
                setList(game_2, 2);
            } else if(use_detail.equals("오버워치_60만원대")) {
                setList(game_3, 2);
            } else if(use_detail.equals("배그_90만원대")) {
                setList(game_4, 2);
            } else if(use_detail.equals("배그_130만원대")) {
                setList(game_5, 2);
            } else if(use_detail.equals("배그_140만원대")) {
                setList(game_6, 2);
            }
        }
    }

    public void setList(String[] strings, int set) {
        Casepart casepart = null;
        Cpupart cpupart = null;
        Coolerpart coolerpart = null;
        Mainboardpart mainboardpart = null;
        Vgapart vgapart = null;
        Rampart rampart = null;
        Storagepart storagepart = null;
        Powerpart powerpart = null;

        try {
            dbReader = new DBReader();
            casepart = (Casepart) dbReader.execute("case", strings[7]).get().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(strings[1] != "") {
            try {
                dbReader = new DBReader();
                coolerpart = (Coolerpart) dbReader.execute("cooler", strings[1]).get().get(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            dbReader = new DBReader();
            cpupart = (Cpupart) dbReader.execute("cpu", strings[0]).get().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(strings[4] != "") {
            try {
                dbReader = new DBReader();
                vgapart = (Vgapart) dbReader.execute("vga", strings[4]).get().get(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            dbReader = new DBReader();
            mainboardpart = (Mainboardpart) dbReader.execute("mb", strings[2]).get().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            dbReader = new DBReader();
            rampart = (Rampart) dbReader.execute("ram", strings[3]).get().get(0);
            rampart.setSet(set);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            dbReader = new DBReader();
            storagepart = (Storagepart) dbReader.execute("storage", strings[5]).get().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            dbReader = new DBReader();
            powerpart = (Powerpart) dbReader.execute("power", strings[6]).get().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        selectpart.setCasepart(casepart);
        selectpart.setCpupart(cpupart);
        selectpart.setCoolerpart(coolerpart);
        selectpart.setMainboardpart(mainboardpart);
        selectpart.setVgapart(vgapart);
        selectpart.setRampart(rampart);
        selectpart.setStoragepart(storagepart);
        selectpart.setPowerpart(powerpart);
    }
}
