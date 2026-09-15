package drr.enrichment.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.common.validation.EnrichmentDataTypeFormatValidator;
import drr.enrichment.common.validation.EnrichmentDataValidator;
import drr.enrichment.common.validation.exists.EnrichmentDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=EnrichmentData.class)
public class EnrichmentDataMeta implements RosettaMetaData<EnrichmentData> {

	@Override
	public List<Validator<? super EnrichmentData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnrichmentData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnrichmentData> validator(ValidatorFactory factory) {
		return factory.<EnrichmentData>create(EnrichmentDataValidator.class);
	}

	@Override
	public Validator<? super EnrichmentData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnrichmentData>create(EnrichmentDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnrichmentData> validator() {
		return new EnrichmentDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EnrichmentData> typeFormatValidator() {
		return new EnrichmentDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnrichmentData, Set<String>> onlyExistsValidator() {
		return new EnrichmentDataOnlyExistsValidator();
	}
}
