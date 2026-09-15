package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.CommonTradeDataReport71__8;
import iso20022.auth030.jfsa.validation.CommonTradeDataReport71__8TypeFormatValidator;
import iso20022.auth030.jfsa.validation.CommonTradeDataReport71__8Validator;
import iso20022.auth030.jfsa.validation.exists.CommonTradeDataReport71__8OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommonTradeDataReport71__8.class)
public class CommonTradeDataReport71__8Meta implements RosettaMetaData<CommonTradeDataReport71__8> {

	@Override
	public List<Validator<? super CommonTradeDataReport71__8>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonTradeDataReport71__8, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonTradeDataReport71__8> validator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport71__8>create(CommonTradeDataReport71__8Validator.class);
	}

	@Override
	public Validator<? super CommonTradeDataReport71__8> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport71__8>create(CommonTradeDataReport71__8TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport71__8> validator() {
		return new CommonTradeDataReport71__8Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport71__8> typeFormatValidator() {
		return new CommonTradeDataReport71__8TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonTradeDataReport71__8, Set<String>> onlyExistsValidator() {
		return new CommonTradeDataReport71__8OnlyExistsValidator();
	}
}
