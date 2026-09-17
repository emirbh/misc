package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityStartingDate;
import fpml.consolidated.com.validation.CommodityStartingDateTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityStartingDateValidator;
import fpml.consolidated.com.validation.datarule.CommodityStartingDateChoice;
import fpml.consolidated.com.validation.exists.CommodityStartingDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityStartingDate.class)
public class CommodityStartingDateMeta implements RosettaMetaData<CommodityStartingDate> {

	@Override
	public List<Validator<? super CommodityStartingDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityStartingDate>create(CommodityStartingDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityStartingDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityStartingDate> validator(ValidatorFactory factory) {
		return factory.<CommodityStartingDate>create(CommodityStartingDateValidator.class);
	}

	@Override
	public Validator<? super CommodityStartingDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityStartingDate>create(CommodityStartingDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityStartingDate> validator() {
		return new CommodityStartingDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityStartingDate> typeFormatValidator() {
		return new CommodityStartingDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityStartingDate, Set<String>> onlyExistsValidator() {
		return new CommodityStartingDateOnlyExistsValidator();
	}
}
