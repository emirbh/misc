package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.MarginReportData7;
import iso20022.auth108.iso.validation.MarginReportData7TypeFormatValidator;
import iso20022.auth108.iso.validation.MarginReportData7Validator;
import iso20022.auth108.iso.validation.exists.MarginReportData7OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MarginReportData7.class)
public class MarginReportData7Meta implements RosettaMetaData<MarginReportData7> {

	@Override
	public List<Validator<? super MarginReportData7>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarginReportData7, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MarginReportData7> validator(ValidatorFactory factory) {
		return factory.<MarginReportData7>create(MarginReportData7Validator.class);
	}

	@Override
	public Validator<? super MarginReportData7> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MarginReportData7>create(MarginReportData7TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MarginReportData7> validator() {
		return new MarginReportData7Validator();
	}

	@Deprecated
	@Override
	public Validator<? super MarginReportData7> typeFormatValidator() {
		return new MarginReportData7TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarginReportData7, Set<String>> onlyExistsValidator() {
		return new MarginReportData7OnlyExistsValidator();
	}
}
