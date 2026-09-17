package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.Nationalization;
import cdm.legaldocumentation.transaction.additionalterms.validation.NationalizationTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.NationalizationValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.datarule.NationalizationAssignmentOfClaim;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.NationalizationOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=Nationalization.class)
public class NationalizationMeta implements RosettaMetaData<Nationalization> {

	@Override
	public List<Validator<? super Nationalization>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Nationalization>create(NationalizationAssignmentOfClaim.class)
		);
	}
	
	@Override
	public List<Function<? super Nationalization, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Nationalization> validator(ValidatorFactory factory) {
		return factory.<Nationalization>create(NationalizationValidator.class);
	}

	@Override
	public Validator<? super Nationalization> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Nationalization>create(NationalizationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Nationalization> validator() {
		return new NationalizationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Nationalization> typeFormatValidator() {
		return new NationalizationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Nationalization, Set<String>> onlyExistsValidator() {
		return new NationalizationOnlyExistsValidator();
	}
}
