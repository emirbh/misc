package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.RegimeReportingSide;
import drr.regulation.common.validation.RegimeReportingSideTypeFormatValidator;
import drr.regulation.common.validation.RegimeReportingSideValidator;
import drr.regulation.common.validation.datarule.RegimeReportingSideReportingSide;
import drr.regulation.common.validation.exists.RegimeReportingSideOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=RegimeReportingSide.class)
public class RegimeReportingSideMeta implements RosettaMetaData<RegimeReportingSide> {

	@Override
	public List<Validator<? super RegimeReportingSide>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RegimeReportingSide>create(RegimeReportingSideReportingSide.class)
		);
	}
	
	@Override
	public List<Function<? super RegimeReportingSide, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegimeReportingSide> validator(ValidatorFactory factory) {
		return factory.<RegimeReportingSide>create(RegimeReportingSideValidator.class);
	}

	@Override
	public Validator<? super RegimeReportingSide> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegimeReportingSide>create(RegimeReportingSideTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegimeReportingSide> validator() {
		return new RegimeReportingSideValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegimeReportingSide> typeFormatValidator() {
		return new RegimeReportingSideTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegimeReportingSide, Set<String>> onlyExistsValidator() {
		return new RegimeReportingSideOnlyExistsValidator();
	}
}
