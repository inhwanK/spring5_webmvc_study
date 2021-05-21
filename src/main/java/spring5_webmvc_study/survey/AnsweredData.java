package spring5_webmvc_study.survey;

import java.util.List;

public class AnsweredData {
    private List<String> responses;
    private Respondent res;

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }

    public Respondent getRes() {
        return res;
    }

    public void setRes(Respondent res) {
        this.res = res;
    }

	@Override
	public String toString() {
		return String.format("AnsweredData [responses=%s, res=%s]", responses, res);
	}
    
}
