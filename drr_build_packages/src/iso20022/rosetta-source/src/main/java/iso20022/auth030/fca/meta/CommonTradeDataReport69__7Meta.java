package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.CommonTradeDataReport69__7;
import iso20022.auth030.fca.validation.CommonTradeDataReport69__7TypeFormatValidator;
import iso20022.auth030.fca.validation.CommonTradeDataReport69__7Validator;
import iso20022.auth030.fca.validation.exists.CommonTradeDataReport69__7OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommonTradeDataReport69__7.class)
public class CommonTradeDataReport69__7Meta implements RosettaMetaData<CommonTradeDataReport69__7> {

	@Override
	public List<Validator<? super CommonTradeDataReport69__7>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonTradeDataReport69__7, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonTradeDataReport69__7> validator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport69__7>create(CommonTradeDataReport69__7Validator.class);
	}

	@Override
	public Validator<? super CommonTradeDataReport69__7> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport69__7>create(CommonTradeDataReport69__7TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport69__7> validator() {
		return new CommonTradeDataReport69__7Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport69__7> typeFormatValidator() {
		return new CommonTradeDataReport69__7TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonTradeDataReport69__7, Set<String>> onlyExistsValidator() {
		return new CommonTradeDataReport69__7OnlyExistsValidator();
	}
}
