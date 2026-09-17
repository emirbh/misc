package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.PostingObligations;
import cdm.legaldocumentation.csa.validation.PostingObligationsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.PostingObligationsValidator;
import cdm.legaldocumentation.csa.validation.exists.PostingObligationsOnlyExistsValidator;
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
@RosettaMeta(model=PostingObligations.class)
public class PostingObligationsMeta implements RosettaMetaData<PostingObligations> {

	@Override
	public List<Validator<? super PostingObligations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PostingObligations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PostingObligations> validator(ValidatorFactory factory) {
		return factory.<PostingObligations>create(PostingObligationsValidator.class);
	}

	@Override
	public Validator<? super PostingObligations> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PostingObligations>create(PostingObligationsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PostingObligations> validator() {
		return new PostingObligationsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PostingObligations> typeFormatValidator() {
		return new PostingObligationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PostingObligations, Set<String>> onlyExistsValidator() {
		return new PostingObligationsOnlyExistsValidator();
	}
}
