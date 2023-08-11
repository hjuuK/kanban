package validators;

public interface MobileValidator {
    default boolean mobileCheck(String num) {
        /**
         *  1. 010, 011, 016, 000~0000, 0000
         *  2. 010-0000-0000, 010.0000.0000, 010_0000_0000, 01000000000 : 숫자가 아닌 문자는 제거, 숫자만 남기기
         */

        num = num.replaceAll("\\D", ""); // 숫자가 아닌 패턴을 넣으면 숫자만 남음 / 숫자가 아닌것은 제거
        String pattern = "^01[016]\\d{3,4}\\d{4}$";
        // ^: 010, 011, 016로 시작 / 3자리에서 4자리 사이 / 4자리 $: 끝나는 패턴 // ^, &가 없으면 01010100000000011122 처럼 사이에만 있어도 체크됨

        return num.matches(pattern);
    }
}
