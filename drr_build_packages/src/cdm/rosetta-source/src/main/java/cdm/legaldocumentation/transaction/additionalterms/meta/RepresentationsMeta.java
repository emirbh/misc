package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.Representations;
import cdm.legaldocumentation.transaction.additionalterms.validation.RepresentationsTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.RepresentationsValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.RepresentationsOnlyExistsValidator;
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
@RosettaMeta(model=Representations.class)
public class RepresentationsMeta implements RosettaMetaData<Representations> {

	@Override
	public List<Validator<? super Representations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Representations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Representations> validator(ValidatorFactory factory) {
		return factory.<Representations>create(RepresentationsValidator.class);
	}

	@Override
	public Validator<? super Representations> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Representations>create(RepresentationsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Representations> validator() {
		return new RepresentationsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Representations> typeFormatValidator() {
		return new RepresentationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Representations, Set<String>> onlyExistsValidator() {
		return new RepresentationsOnlyExistsValidator();
	}
}
