package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.PhysicalSettlementTerms;
import fpml.consolidated.cd.validation.PhysicalSettlementTermsTypeFormatValidator;
import fpml.consolidated.cd.validation.PhysicalSettlementTermsValidator;
import fpml.consolidated.cd.validation.exists.PhysicalSettlementTermsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PhysicalSettlementTerms.class)
public class PhysicalSettlementTermsMeta implements RosettaMetaData<PhysicalSettlementTerms> {

	@Override
	public List<Validator<? super PhysicalSettlementTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PhysicalSettlementTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PhysicalSettlementTerms> validator(ValidatorFactory factory) {
		return factory.<PhysicalSettlementTerms>create(PhysicalSettlementTermsValidator.class);
	}

	@Override
	public Validator<? super PhysicalSettlementTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PhysicalSettlementTerms>create(PhysicalSettlementTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalSettlementTerms> validator() {
		return new PhysicalSettlementTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalSettlementTerms> typeFormatValidator() {
		return new PhysicalSettlementTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PhysicalSettlementTerms, Set<String>> onlyExistsValidator() {
		return new PhysicalSettlementTermsOnlyExistsValidator();
	}
}
