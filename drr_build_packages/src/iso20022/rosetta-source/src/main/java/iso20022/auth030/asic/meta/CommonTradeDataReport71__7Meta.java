package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.CommonTradeDataReport71__7;
import iso20022.auth030.asic.validation.CommonTradeDataReport71__7TypeFormatValidator;
import iso20022.auth030.asic.validation.CommonTradeDataReport71__7Validator;
import iso20022.auth030.asic.validation.exists.CommonTradeDataReport71__7OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommonTradeDataReport71__7.class)
public class CommonTradeDataReport71__7Meta implements RosettaMetaData<CommonTradeDataReport71__7> {

	@Override
	public List<Validator<? super CommonTradeDataReport71__7>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonTradeDataReport71__7, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonTradeDataReport71__7> validator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport71__7>create(CommonTradeDataReport71__7Validator.class);
	}

	@Override
	public Validator<? super CommonTradeDataReport71__7> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport71__7>create(CommonTradeDataReport71__7TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport71__7> validator() {
		return new CommonTradeDataReport71__7Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport71__7> typeFormatValidator() {
		return new CommonTradeDataReport71__7TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonTradeDataReport71__7, Set<String>> onlyExistsValidator() {
		return new CommonTradeDataReport71__7OnlyExistsValidator();
	}
}
