package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.NotionalQuantity9__1;
import iso20022.auth030.hkma.tr.validation.NotionalQuantity9__1TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.NotionalQuantity9__1Validator;
import iso20022.auth030.hkma.tr.validation.exists.NotionalQuantity9__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NotionalQuantity9__1.class)
public class NotionalQuantity9__1Meta implements RosettaMetaData<NotionalQuantity9__1> {

	@Override
	public List<Validator<? super NotionalQuantity9__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalQuantity9__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalQuantity9__1> validator(ValidatorFactory factory) {
		return factory.<NotionalQuantity9__1>create(NotionalQuantity9__1Validator.class);
	}

	@Override
	public Validator<? super NotionalQuantity9__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalQuantity9__1>create(NotionalQuantity9__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalQuantity9__1> validator() {
		return new NotionalQuantity9__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalQuantity9__1> typeFormatValidator() {
		return new NotionalQuantity9__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalQuantity9__1, Set<String>> onlyExistsValidator() {
		return new NotionalQuantity9__1OnlyExistsValidator();
	}
}
