package fpml.consolidated.confirmation.processes;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.OptionEvent;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.OptionExpiry;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.meta.OptionExpirationNotificationMeta;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatoryReportingCollateralization;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.Party;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="OptionExpirationNotification", builder=OptionExpirationNotification.OptionExpirationNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OptionExpirationNotification", model="fpml", builder=OptionExpirationNotification.OptionExpirationNotificationBuilderImpl.class, version="2.1.1")
public interface OptionExpirationNotification extends ExecutionNotification {

	OptionExpirationNotificationMeta metaData = new OptionExpirationNotificationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	OptionExpirationNotification build();
	
	OptionExpirationNotification.OptionExpirationNotificationBuilder toBuilder();
	
	static OptionExpirationNotification.OptionExpirationNotificationBuilder builder() {
		return new OptionExpirationNotification.OptionExpirationNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExpirationNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionExpirationNotification> getType() {
		return OptionExpirationNotification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.class, getTradePackage());
		processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.class, getOriginatingEvent());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("amendment"), processor, TradeAmendmentContent.class, getAmendment());
		processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.class, getOptionExercise());
		processRosetta(path.newSubPath("optionExpiry"), processor, OptionExpiry.class, getOptionExpiry());
		processRosetta(path.newSubPath("optionEvent"), processor, OptionEvent.class, getOptionEvent());
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
		processRosetta(path.newSubPath("quote"), processor, BasicQuotation.class, getQuote());
		processRosetta(path.newSubPath("collateralization"), processor, RegulatoryReportingCollateralization.class, getCollateralization());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExpirationNotificationBuilder extends OptionExpirationNotification, ExecutionNotification.ExecutionNotificationBuilder {
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addValidation(Validation validation);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setTradePackage(TradePackage tradePackage);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setTrade(Trade trade);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setAmendment(TradeAmendmentContent amendment);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setOptionExercise(OptionExercise optionExercise);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addOptionExpiry(OptionExpiry optionExpiry);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addOptionExpiry(OptionExpiry optionExpiry, int idx);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addOptionExpiry(List<? extends OptionExpiry> optionExpiry);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setOptionExpiry(List<? extends OptionExpiry> optionExpiry);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setOptionEvent(OptionEvent optionEvent);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setAdditionalEvent(AdditionalEvent additionalEvent);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addQuote(BasicQuotation quote);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addQuote(BasicQuotation quote, int idx);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addQuote(List<? extends BasicQuotation> quote);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setQuote(List<? extends BasicQuotation> quote);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addCollateralization(RegulatoryReportingCollateralization collateralization);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addCollateralization(RegulatoryReportingCollateralization collateralization, int idx);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addCollateralization(List<? extends RegulatoryReportingCollateralization> collateralization);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setCollateralization(List<? extends RegulatoryReportingCollateralization> collateralization);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addParty(Party party);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addParty(Party party, int idx);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addParty(List<? extends Party> party);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setParty(List<? extends Party> party);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addAccount(Account account);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addAccount(Account account, int idx);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder addAccount(List<? extends Account> account);
		@Override
		OptionExpirationNotification.OptionExpirationNotificationBuilder setAccount(List<? extends Account> account);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.TradePackageBuilder.class, getTradePackage());
			processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.OriginatingEventBuilder.class, getOriginatingEvent());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("amendment"), processor, TradeAmendmentContent.TradeAmendmentContentBuilder.class, getAmendment());
			processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.OptionExerciseBuilder.class, getOptionExercise());
			processRosetta(path.newSubPath("optionExpiry"), processor, OptionExpiry.OptionExpiryBuilder.class, getOptionExpiry());
			processRosetta(path.newSubPath("optionEvent"), processor, OptionEvent.OptionEventBuilder.class, getOptionEvent());
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
			processRosetta(path.newSubPath("quote"), processor, BasicQuotation.BasicQuotationBuilder.class, getQuote());
			processRosetta(path.newSubPath("collateralization"), processor, RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder.class, getCollateralization());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		OptionExpirationNotification.OptionExpirationNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of OptionExpirationNotification  ***********************/
	class OptionExpirationNotificationImpl extends ExecutionNotification.ExecutionNotificationImpl implements OptionExpirationNotification {
		
		protected OptionExpirationNotificationImpl(OptionExpirationNotification.OptionExpirationNotificationBuilder builder) {
			super(builder);
		}
		
		@Override
		public OptionExpirationNotification build() {
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder toBuilder() {
			OptionExpirationNotification.OptionExpirationNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExpirationNotification.OptionExpirationNotificationBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExpirationNotification {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionExpirationNotification  ***********************/
	class OptionExpirationNotificationBuilderImpl extends ExecutionNotification.ExecutionNotificationBuilderImpl implements OptionExpirationNotification.OptionExpirationNotificationBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addValidation(List<? extends Validation> validations) {
			if (validations != null) {
				for (final Validation toAdd : validations) {
					this.validation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("isCorrection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCorrection")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds != null) {
				for (final CorrelationId toAdd : correlationIds) {
					this.correlationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds == null) {
				this.correlationId = new ArrayList<>();
			} else {
				this.correlationId = correlationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sequenceNumber")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs != null) {
				for (final OnBehalfOf toAdd : onBehalfOfs) {
					this.onBehalfOf.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradePackage")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setTradePackage(TradePackage _tradePackage) {
			this.tradePackage = _tradePackage == null ? null : _tradePackage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingEvent")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setOriginatingEvent(OriginatingEvent _originatingEvent) {
			this.originatingEvent = _originatingEvent == null ? null : _originatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amendment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendment")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setAmendment(TradeAmendmentContent _amendment) {
			this.amendment = _amendment == null ? null : _amendment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionExercise")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setOptionExercise(OptionExercise _optionExercise) {
			this.optionExercise = _optionExercise == null ? null : _optionExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionExpiry")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("optionExpiry")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addOptionExpiry(OptionExpiry _optionExpiry) {
			if (_optionExpiry != null) {
				this.optionExpiry.add(_optionExpiry.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addOptionExpiry(OptionExpiry _optionExpiry, int idx) {
			getIndex(this.optionExpiry, idx, () -> _optionExpiry.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addOptionExpiry(List<? extends OptionExpiry> optionExpirys) {
			if (optionExpirys != null) {
				for (final OptionExpiry toAdd : optionExpirys) {
					this.optionExpiry.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("optionExpiry")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("optionExpiry")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setOptionExpiry(List<? extends OptionExpiry> optionExpirys) {
			if (optionExpirys == null) {
				this.optionExpiry = new ArrayList<>();
			} else {
				this.optionExpiry = optionExpirys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionEvent")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setOptionEvent(OptionEvent _optionEvent) {
			this.optionEvent = _optionEvent == null ? null : _optionEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalEvent")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setAdditionalEvent(AdditionalEvent _additionalEvent) {
			this.additionalEvent = _additionalEvent == null ? null : _additionalEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addQuote(BasicQuotation _quote) {
			if (_quote != null) {
				this.quote.add(_quote.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addQuote(BasicQuotation _quote, int idx) {
			getIndex(this.quote, idx, () -> _quote.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addQuote(List<? extends BasicQuotation> quotes) {
			if (quotes != null) {
				for (final BasicQuotation toAdd : quotes) {
					this.quote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setQuote(List<? extends BasicQuotation> quotes) {
			if (quotes == null) {
				this.quote = new ArrayList<>();
			} else {
				this.quote = quotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("collateralization")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("collateralization")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addCollateralization(RegulatoryReportingCollateralization _collateralization) {
			if (_collateralization != null) {
				this.collateralization.add(_collateralization.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addCollateralization(RegulatoryReportingCollateralization _collateralization, int idx) {
			getIndex(this.collateralization, idx, () -> _collateralization.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addCollateralization(List<? extends RegulatoryReportingCollateralization> collateralizations) {
			if (collateralizations != null) {
				for (final RegulatoryReportingCollateralization toAdd : collateralizations) {
					this.collateralization.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("collateralization")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("collateralization")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setCollateralization(List<? extends RegulatoryReportingCollateralization> collateralizations) {
			if (collateralizations == null) {
				this.collateralization = new ArrayList<>();
			} else {
				this.collateralization = collateralizations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("account")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("account")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder addAccount(List<? extends Account> accounts) {
			if (accounts != null) {
				for (final Account toAdd : accounts) {
					this.account.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("account")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("account")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder setAccount(List<? extends Account> accounts) {
			if (accounts == null) {
				this.account = new ArrayList<>();
			} else {
				this.account = accounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public OptionExpirationNotification build() {
			return new OptionExpirationNotification.OptionExpirationNotificationImpl(this);
		}
		
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExpirationNotification.OptionExpirationNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			OptionExpirationNotification.OptionExpirationNotificationBuilder o = (OptionExpirationNotification.OptionExpirationNotificationBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExpirationNotificationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
