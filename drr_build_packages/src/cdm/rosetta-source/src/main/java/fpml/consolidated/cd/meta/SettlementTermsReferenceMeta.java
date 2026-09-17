package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.SettlementTermsReference;
import fpml.consolidated.cd.validation.SettlementTermsReferenceTypeFormatValidator;
import fpml.consolidated.cd.validation.SettlementTermsReferenceValidator;
import fpml.consolidated.cd.validation.exists.SettlementTermsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementTermsReference.class)
public class SettlementTermsReferenceMeta implements RosettaMetaData<SettlementTermsReference> {

	@Override
	public List<Validator<? super SettlementTermsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementTermsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementTermsReference> validator(ValidatorFactory factory) {
		return factory.<SettlementTermsReference>create(SettlementTermsReferenceValidator.class);
	}

	@Override
	public Validator<? super SettlementTermsReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementTermsReference>create(SettlementTermsReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementTermsReference> validator() {
		return new SettlementTermsReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementTermsReference> typeFormatValidator() {
		return new SettlementTermsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementTermsReference, Set<String>> onlyExistsValidator() {
		return new SettlementTermsReferenceOnlyExistsValidator();
	}
}
