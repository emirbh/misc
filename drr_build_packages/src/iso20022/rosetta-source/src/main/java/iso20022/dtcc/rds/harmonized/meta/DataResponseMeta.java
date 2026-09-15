package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.DataResponse;
import iso20022.dtcc.rds.harmonized.validation.DataResponseTypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.DataResponseValidator;
import iso20022.dtcc.rds.harmonized.validation.exists.DataResponseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DataResponse.class)
public class DataResponseMeta implements RosettaMetaData<DataResponse> {

	@Override
	public List<Validator<? super DataResponse>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DataResponse, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DataResponse> validator(ValidatorFactory factory) {
		return factory.<DataResponse>create(DataResponseValidator.class);
	}

	@Override
	public Validator<? super DataResponse> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DataResponse>create(DataResponseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DataResponse> validator() {
		return new DataResponseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DataResponse> typeFormatValidator() {
		return new DataResponseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DataResponse, Set<String>> onlyExistsValidator() {
		return new DataResponseOnlyExistsValidator();
	}
}
