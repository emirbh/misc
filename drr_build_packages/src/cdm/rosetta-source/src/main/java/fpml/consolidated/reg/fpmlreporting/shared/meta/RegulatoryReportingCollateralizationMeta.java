package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatoryReportingCollateralization;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RegulatoryReportingCollateralizationTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RegulatoryReportingCollateralizationValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.RegulatoryReportingCollateralizationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingCollateralization.class)
public class RegulatoryReportingCollateralizationMeta implements RosettaMetaData<RegulatoryReportingCollateralization> {

	@Override
	public List<Validator<? super RegulatoryReportingCollateralization>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingCollateralization, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingCollateralization> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingCollateralization>create(RegulatoryReportingCollateralizationValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingCollateralization> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingCollateralization>create(RegulatoryReportingCollateralizationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingCollateralization> validator() {
		return new RegulatoryReportingCollateralizationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingCollateralization> typeFormatValidator() {
		return new RegulatoryReportingCollateralizationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingCollateralization, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingCollateralizationOnlyExistsValidator();
	}
}
