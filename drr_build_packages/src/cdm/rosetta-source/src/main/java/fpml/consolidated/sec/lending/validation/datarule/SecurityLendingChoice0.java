package fpml.consolidated.sec.lending.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.ExtensionStyleEnum;
import fpml.consolidated.fpmlenum.SecLendCallingPartyEnum;
import fpml.consolidated.repo.AdjustableOffset;
import fpml.consolidated.repo.PartyNoticePeriod;
import fpml.consolidated.sec.lending.SecurityLending;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SecurityLendingChoice0")
@ImplementedBy(SecurityLendingChoice0.Default.class)
public interface SecurityLendingChoice0 extends Validator<SecurityLending> {
	
	String NAME = "SecurityLendingChoice0";
	String DEFINITION = "if extensionStyle exists then callingParty is absent and callDate is absent and noticePeriod is absent and partyNoticePeriod is absent else if callingParty exists then if partyNoticePeriod exists then noticePeriod is absent and extensionPeriod is absent else partyNoticePeriod is absent and extensionPeriod is absent else extensionPeriod is absent and callDate is absent and noticePeriod is absent and partyNoticePeriod is absent";
	
	class Default implements SecurityLendingChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityLending securityLending) {
			ComparisonResult result = executeDataRule(securityLending);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SecurityLending", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SecurityLending", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SecurityLending securityLending) {
			try {
				if (exists(MapperS.of(securityLending).<ExtensionStyleEnum>map("getExtensionStyle", _securityLending -> _securityLending.getExtensionStyle())).getOrDefault(false)) {
					return notExists(MapperS.of(securityLending).<SecLendCallingPartyEnum>map("getCallingParty", _securityLending -> _securityLending.getCallingParty())).andNullSafe(notExists(MapperS.of(securityLending).<AdjustableOrRelativeDate>map("getCallDate", _securityLending -> _securityLending.getCallDate()))).andNullSafe(notExists(MapperS.of(securityLending).<AdjustableOffset>map("getNoticePeriod", _securityLending -> _securityLending.getNoticePeriod()))).andNullSafe(notExists(MapperS.of(securityLending).<PartyNoticePeriod>mapC("getPartyNoticePeriod", _securityLending -> _securityLending.getPartyNoticePeriod())));
				}
				if (exists(MapperS.of(securityLending).<SecLendCallingPartyEnum>map("getCallingParty", _securityLending -> _securityLending.getCallingParty())).getOrDefault(false)) {
					if (exists(MapperS.of(securityLending).<PartyNoticePeriod>mapC("getPartyNoticePeriod", _securityLending -> _securityLending.getPartyNoticePeriod())).getOrDefault(false)) {
						return notExists(MapperS.of(securityLending).<AdjustableOffset>map("getNoticePeriod", _securityLending -> _securityLending.getNoticePeriod())).andNullSafe(notExists(MapperS.of(securityLending).<AdjustableOffset>map("getExtensionPeriod", _securityLending -> _securityLending.getExtensionPeriod())));
					}
					return notExists(MapperS.of(securityLending).<PartyNoticePeriod>mapC("getPartyNoticePeriod", _securityLending -> _securityLending.getPartyNoticePeriod())).andNullSafe(notExists(MapperS.of(securityLending).<AdjustableOffset>map("getExtensionPeriod", _securityLending -> _securityLending.getExtensionPeriod())));
				}
				return notExists(MapperS.of(securityLending).<AdjustableOffset>map("getExtensionPeriod", _securityLending -> _securityLending.getExtensionPeriod())).andNullSafe(notExists(MapperS.of(securityLending).<AdjustableOrRelativeDate>map("getCallDate", _securityLending -> _securityLending.getCallDate()))).andNullSafe(notExists(MapperS.of(securityLending).<AdjustableOffset>map("getNoticePeriod", _securityLending -> _securityLending.getNoticePeriod()))).andNullSafe(notExists(MapperS.of(securityLending).<PartyNoticePeriod>mapC("getPartyNoticePeriod", _securityLending -> _securityLending.getPartyNoticePeriod())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SecurityLendingChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityLending securityLending) {
			return Collections.emptyList();
		}
	}
}
