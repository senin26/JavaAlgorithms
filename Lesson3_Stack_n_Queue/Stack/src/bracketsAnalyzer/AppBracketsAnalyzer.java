package bracketsAnalyzer;

public class AppBracketsAnalyzer {
    public static void main(String[] args) {
        MathExpression mathExpression = new MathExpression("(a+b+6*)({755-5*[5+6]}+4564)");
        BracketsAnalyser bracketsAnalyser = new BracketsAnalyser();
        bracketsAnalyser.printAnalysisResult(mathExpression);
    }
}
