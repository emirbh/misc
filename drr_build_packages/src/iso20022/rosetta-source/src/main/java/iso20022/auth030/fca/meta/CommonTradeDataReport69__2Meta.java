package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.CommonTradeDataReport69__2;
import iso20022.auth030.fca.validation.CommonTradeDataReport69__2TypeFormatValidator;
import iso20022.auth030.fca.validation.CommonTradeDataReport69__2Validator;
import iso20022.auth030.fca.validation.exists.CommonTradeDataReport69__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommonTradeDataReport69__2.class)
public class CommonTradeDataReport69__2Meta implements RosettaMetaData<CommonTradeDataReport69__2> {

	@Override
	public List<Validator<? super CommonTradeDataReport69__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonTradeDataReport69__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonTradeDataReport69__2> validator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport69__2>create(CommonTradeDataReport69__2Validator.class);
	}

	@Override
	public Validator<? super CommonTradeDataReport69__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonTradeDataReport69__2>create(CommonTradeDataReport69__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport69__2> validator() {
		return new CommonTradeDataReport69__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonTradeDataReport69__2> typeFormatValidator() {
		return new CommonTradeDataReport69__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonTradeDataReport69__2, Set<String>> onlyExistsValidator() {
		return new CommonTradeDataReport69__2OnlyExistsValidator();
	}
}
