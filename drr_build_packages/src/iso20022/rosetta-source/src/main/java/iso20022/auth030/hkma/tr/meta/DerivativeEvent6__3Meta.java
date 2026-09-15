package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.DerivativeEvent6__3;
import iso20022.auth030.hkma.tr.validation.DerivativeEvent6__3TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.DerivativeEvent6__3Validator;
import iso20022.auth030.hkma.tr.validation.exists.DerivativeEvent6__3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativeEvent6__3.class)
public class DerivativeEvent6__3Meta implements RosettaMetaData<DerivativeEvent6__3> {

	@Override
	public List<Validator<? super DerivativeEvent6__3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DerivativeEvent6__3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DerivativeEvent6__3> validator(ValidatorFactory factory) {
		return factory.<DerivativeEvent6__3>create(DerivativeEvent6__3Validator.class);
	}

	@Override
	public Validator<? super DerivativeEvent6__3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DerivativeEvent6__3>create(DerivativeEvent6__3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeEvent6__3> validator() {
		return new DerivativeEvent6__3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeEvent6__3> typeFormatValidator() {
		return new DerivativeEvent6__3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativeEvent6__3, Set<String>> onlyExistsValidator() {
		return new DerivativeEvent6__3OnlyExistsValidator();
	}
}
