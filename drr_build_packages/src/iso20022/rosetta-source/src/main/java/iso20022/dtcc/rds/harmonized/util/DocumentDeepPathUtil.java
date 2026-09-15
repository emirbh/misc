package iso20022.dtcc.rds.harmonized.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.dtcc.rds.harmonized.Core;
import iso20022.dtcc.rds.harmonized.DataResponse;
import iso20022.dtcc.rds.harmonized.DataSubmission;
import iso20022.dtcc.rds.harmonized.Document;
import iso20022.dtcc.rds.harmonized.Header;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class DocumentDeepPathUtil {
    public Core chooseCore(Document document) {
        final MapperS<DataSubmission> submission = MapperS.of(document).<DataSubmission>map("getSubmission", _document -> _document.getSubmission());
        if (exists(submission).getOrDefault(false)) {
            return submission.<Core>map("getCore", dataSubmission -> dataSubmission.getCore()).get();
        }
        final MapperS<DataResponse> response = MapperS.of(document).<DataResponse>map("getResponse", _document -> _document.getResponse());
        if (exists(response).getOrDefault(false)) {
            return response.<Core>map("getCore", dataResponse -> dataResponse.getCore()).get();
        }
        return null;
    }

    public Header chooseHeader(Document document) {
        final MapperS<DataSubmission> submission = MapperS.of(document).<DataSubmission>map("getSubmission", _document -> _document.getSubmission());
        if (exists(submission).getOrDefault(false)) {
            return submission.<Header>map("getHeader", dataSubmission -> dataSubmission.getHeader()).get();
        }
        final MapperS<DataResponse> response = MapperS.of(document).<DataResponse>map("getResponse", _document -> _document.getResponse());
        if (exists(response).getOrDefault(false)) {
            return response.<Header>map("getHeader", dataResponse -> dataResponse.getHeader()).get();
        }
        return null;
    }

}
