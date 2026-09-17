package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.MarketReference;
import fpml.consolidated.riskdef.validation.MarketReferenceTypeFormatValidator;
import fpml.consolidated.riskdef.validation.MarketReferenceValidator;
import fpml.consolidated.riskdef.validation.exists.MarketReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MarketReference.class)
public class MarketReferenceMeta implements RosettaMetaData<MarketReference> {

	@Override
	public List<Validator<? super MarketReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarketReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MarketReference> validator(ValidatorFactory factory) {
		return factory.<MarketReference>create(MarketReferenceValidator.class);
	}

	@Override
	public Validator<? super MarketReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MarketReference>create(MarketReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MarketReference> validator() {
		return new MarketReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MarketReference> typeFormatValidator() {
		return new MarketReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarketReference, Set<String>> onlyExistsValidator() {
		return new MarketReferenceOnlyExistsValidator();
	}
}
