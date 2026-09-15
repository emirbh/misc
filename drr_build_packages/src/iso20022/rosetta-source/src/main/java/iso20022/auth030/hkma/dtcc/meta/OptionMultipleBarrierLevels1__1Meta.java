package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.OptionMultipleBarrierLevels1__1;
import iso20022.auth030.hkma.dtcc.validation.OptionMultipleBarrierLevels1__1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.OptionMultipleBarrierLevels1__1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.OptionMultipleBarrierLevels1__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionMultipleBarrierLevels1__1.class)
public class OptionMultipleBarrierLevels1__1Meta implements RosettaMetaData<OptionMultipleBarrierLevels1__1> {

	@Override
	public List<Validator<? super OptionMultipleBarrierLevels1__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionMultipleBarrierLevels1__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionMultipleBarrierLevels1__1> validator(ValidatorFactory factory) {
		return factory.<OptionMultipleBarrierLevels1__1>create(OptionMultipleBarrierLevels1__1Validator.class);
	}

	@Override
	public Validator<? super OptionMultipleBarrierLevels1__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionMultipleBarrierLevels1__1>create(OptionMultipleBarrierLevels1__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionMultipleBarrierLevels1__1> validator() {
		return new OptionMultipleBarrierLevels1__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionMultipleBarrierLevels1__1> typeFormatValidator() {
		return new OptionMultipleBarrierLevels1__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionMultipleBarrierLevels1__1, Set<String>> onlyExistsValidator() {
		return new OptionMultipleBarrierLevels1__1OnlyExistsValidator();
	}
}
