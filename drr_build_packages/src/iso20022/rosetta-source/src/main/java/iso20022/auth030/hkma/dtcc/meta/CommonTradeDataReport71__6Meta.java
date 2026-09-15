package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.CommonTradeDataReport71__6;
import iso20022.auth030.hkma.dtcc.validation.CommonTradeDataReport71__6TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.CommonTradeDataReport71__6Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.CommonTradeDataReport71__6OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommonTradeDataReport71__6.class)
public class CommonTradeDataReport71__6Meta implements RosettaMetaData<CommonTradeDataReport71__6> {

	@Override
	public List<Validator<? super CommonTradeDataReport71__6>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonTradeDataReport71__6, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonTradeDataReport71__6> validator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport71__6>create(CommonTradeDataReport71__6Validator.class);
	}

	@Override
	public Validator<? super CommonTradeDataReport71__6> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport71__6>create(CommonTradeDataReport71__6TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport71__6> validator() {
		return new CommonTradeDataReport71__6Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport71__6> typeFormatValidator() {
		return new CommonTradeDataReport71__6TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonTradeDataReport71__6, Set<String>> onlyExistsValidator() {
		return new CommonTradeDataReport71__6OnlyExistsValidator();
	}
}
