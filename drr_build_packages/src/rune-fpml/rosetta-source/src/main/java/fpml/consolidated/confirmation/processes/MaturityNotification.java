package fpml.consolidated.confirmation.processes;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.business.events.OptionExpiryBase;
import fpml.consolidated.business.events.TradeMaturity;
import fpml.consolidated.confirmation.processes.meta.MaturityNotificationMeta;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrectableRequestMessage;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A message used to notify another party that a trade has matured. This can be used to report, for example, that a swap has passed its final payment and can be removed, or that an option has expired without being executed.
 *
 */
@RosettaDataType(value="MaturityNotification", builder=MaturityNotification.MaturityNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MaturityNotification", model="fpml", builder=MaturityNotification.MaturityNotificationBuilderImpl.class, version="2.1.1")
public interface MaturityNotification extends CorrectableRequestMessage {

	MaturityNotificationMeta metaData = new MaturityNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	OptionExpiryBase getOptionExpiry();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeMaturity getTradeMaturity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A legal entity or a subdivision of a legal entity. Parties can perform multiple roles in a trade lifecycle. For example, the principal parties obligated to make payments from time to time during the term of the trade, but may include other parties involved in, or incidental to, the trade, such as parties acting in the role of novation transferor/transferee, broker, calculation agent, etc. In FpML roles are defined in multiple places within a document.
	 *
	 */
	List<? extends Party> getParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Optional account information used to precisely define the origination and destination of financial instruments.
	 *
	 */
	List<? extends Account> getAccount();

	/*********************** Build Methods  ***********************/
	MaturityNotification build();
	
	MaturityNotification.MaturityNotificationBuilder toBuilder();
	
	static MaturityNotification.MaturityNotificationBuilder builder() {
		return new MaturityNotification.MaturityNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MaturityNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MaturityNotification> getType() {
		return MaturityNotification.class;
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
		processRosetta(path.newSubPath("optionExpiry"), processor, OptionExpiryBase.class, getOptionExpiry());
		processRosetta(path.newSubPath("tradeMaturity"), processor, TradeMaturity.class, getTradeMaturity());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MaturityNotificationBuilder extends MaturityNotification, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		OptionExpiryBase.OptionExpiryBaseBuilder getOrCreateOptionExpiry();
		@Override
		OptionExpiryBase.OptionExpiryBaseBuilder getOptionExpiry();
		TradeMaturity.TradeMaturityBuilder getOrCreateTradeMaturity();
		@Override
		TradeMaturity.TradeMaturityBuilder getTradeMaturity();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		MaturityNotification.MaturityNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		MaturityNotification.MaturityNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		MaturityNotification.MaturityNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		MaturityNotification.MaturityNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		MaturityNotification.MaturityNotificationBuilder addValidation(Validation validation);
		@Override
		MaturityNotification.MaturityNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		MaturityNotification.MaturityNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		MaturityNotification.MaturityNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		MaturityNotification.MaturityNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		MaturityNotification.MaturityNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		MaturityNotification.MaturityNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		MaturityNotification.MaturityNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		MaturityNotification.MaturityNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		MaturityNotification.MaturityNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		MaturityNotification.MaturityNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		MaturityNotification.MaturityNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		MaturityNotification.MaturityNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		MaturityNotification.MaturityNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		MaturityNotification.MaturityNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		MaturityNotification.MaturityNotificationBuilder setOptionExpiry(OptionExpiryBase optionExpiry);
		MaturityNotification.MaturityNotificationBuilder setTradeMaturity(TradeMaturity tradeMaturity);
		MaturityNotification.MaturityNotificationBuilder addParty(Party party);
		MaturityNotification.MaturityNotificationBuilder addParty(Party party, int idx);
		MaturityNotification.MaturityNotificationBuilder addParty(List<? extends Party> party);
		MaturityNotification.MaturityNotificationBuilder setParty(List<? extends Party> party);
		MaturityNotification.MaturityNotificationBuilder addAccount(Account account);
		MaturityNotification.MaturityNotificationBuilder addAccount(Account account, int idx);
		MaturityNotification.MaturityNotificationBuilder addAccount(List<? extends Account> account);
		MaturityNotification.MaturityNotificationBuilder setAccount(List<? extends Account> account);

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
			processRosetta(path.newSubPath("optionExpiry"), processor, OptionExpiryBase.OptionExpiryBaseBuilder.class, getOptionExpiry());
			processRosetta(path.newSubPath("tradeMaturity"), processor, TradeMaturity.TradeMaturityBuilder.class, getTradeMaturity());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		MaturityNotification.MaturityNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of MaturityNotification  ***********************/
	class MaturityNotificationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements MaturityNotification {
		private final OptionExpiryBase optionExpiry;
		private final TradeMaturity tradeMaturity;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected MaturityNotificationImpl(MaturityNotification.MaturityNotificationBuilder builder) {
			super(builder);
			this.optionExpiry = ofNullable(builder.getOptionExpiry()).map(f->f.build()).orElse(null);
			this.tradeMaturity = ofNullable(builder.getTradeMaturity()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionExpiry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionExpiry")
		public OptionExpiryBase getOptionExpiry() {
			return optionExpiry;
		}
		
		@Override
		@RosettaAttribute("tradeMaturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeMaturity")
		public TradeMaturity getTradeMaturity() {
			return tradeMaturity;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("account")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("account")
		public List<? extends Account> getAccount() {
			return account;
		}
		
		@Override
		public MaturityNotification build() {
			return this;
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder toBuilder() {
			MaturityNotification.MaturityNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MaturityNotification.MaturityNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOptionExpiry()).ifPresent(builder::setOptionExpiry);
			ofNullable(getTradeMaturity()).ifPresent(builder::setTradeMaturity);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MaturityNotification _that = getType().cast(o);
		
			if (!Objects.equals(optionExpiry, _that.getOptionExpiry())) return false;
			if (!Objects.equals(tradeMaturity, _that.getTradeMaturity())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionExpiry != null ? optionExpiry.hashCode() : 0);
			_result = 31 * _result + (tradeMaturity != null ? tradeMaturity.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MaturityNotification {" +
				"optionExpiry=" + this.optionExpiry + ", " +
				"tradeMaturity=" + this.tradeMaturity + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MaturityNotification  ***********************/
	class MaturityNotificationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl implements MaturityNotification.MaturityNotificationBuilder {
	
		protected OptionExpiryBase.OptionExpiryBaseBuilder optionExpiry;
		protected TradeMaturity.TradeMaturityBuilder tradeMaturity;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("optionExpiry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionExpiry")
		public OptionExpiryBase.OptionExpiryBaseBuilder getOptionExpiry() {
			return optionExpiry;
		}
		
		@Override
		public OptionExpiryBase.OptionExpiryBaseBuilder getOrCreateOptionExpiry() {
			OptionExpiryBase.OptionExpiryBaseBuilder result;
			if (optionExpiry!=null) {
				result = optionExpiry;
			}
			else {
				result = optionExpiry = OptionExpiryBase.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeMaturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeMaturity")
		public TradeMaturity.TradeMaturityBuilder getTradeMaturity() {
			return tradeMaturity;
		}
		
		@Override
		public TradeMaturity.TradeMaturityBuilder getOrCreateTradeMaturity() {
			TradeMaturity.TradeMaturityBuilder result;
			if (tradeMaturity!=null) {
				result = tradeMaturity;
			}
			else {
				result = tradeMaturity = TradeMaturity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty(int index) {
			if (party==null) {
				this.party = new ArrayList<>();
			}
			return getIndex(party, index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@Override
		@RosettaAttribute("account")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("account")
		public List<? extends Account.AccountBuilder> getAccount() {
			return account;
		}
		
		@Override
		public Account.AccountBuilder getOrCreateAccount(int index) {
			if (account==null) {
				this.account = new ArrayList<>();
			}
			return getIndex(account, index, () -> {
						Account.AccountBuilder newAccount = Account.builder();
						return newAccount;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public MaturityNotification.MaturityNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public MaturityNotification.MaturityNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public MaturityNotification.MaturityNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public MaturityNotification.MaturityNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public MaturityNotification.MaturityNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder addValidation(List<? extends Validation> validations) {
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
		public MaturityNotification.MaturityNotificationBuilder setValidation(List<? extends Validation> validations) {
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
		public MaturityNotification.MaturityNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public MaturityNotification.MaturityNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public MaturityNotification.MaturityNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public MaturityNotification.MaturityNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public MaturityNotification.MaturityNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public MaturityNotification.MaturityNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public MaturityNotification.MaturityNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionExpiry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionExpiry")
		@Override
		public MaturityNotification.MaturityNotificationBuilder setOptionExpiry(OptionExpiryBase _optionExpiry) {
			this.optionExpiry = _optionExpiry == null ? null : _optionExpiry.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeMaturity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeMaturity")
		@Override
		public MaturityNotification.MaturityNotificationBuilder setTradeMaturity(TradeMaturity _tradeMaturity) {
			this.tradeMaturity = _tradeMaturity == null ? null : _tradeMaturity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public MaturityNotification.MaturityNotificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder addParty(List<? extends Party> partys) {
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
		public MaturityNotification.MaturityNotificationBuilder setParty(List<? extends Party> partys) {
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
		public MaturityNotification.MaturityNotificationBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder addAccount(List<? extends Account> accounts) {
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
		public MaturityNotification.MaturityNotificationBuilder setAccount(List<? extends Account> accounts) {
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
		public MaturityNotification build() {
			return new MaturityNotification.MaturityNotificationImpl(this);
		}
		
		@Override
		public MaturityNotification.MaturityNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MaturityNotification.MaturityNotificationBuilder prune() {
			super.prune();
			if (optionExpiry!=null && !optionExpiry.prune().hasData()) optionExpiry = null;
			if (tradeMaturity!=null && !tradeMaturity.prune().hasData()) tradeMaturity = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOptionExpiry()!=null && getOptionExpiry().hasData()) return true;
			if (getTradeMaturity()!=null && getTradeMaturity().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MaturityNotification.MaturityNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MaturityNotification.MaturityNotificationBuilder o = (MaturityNotification.MaturityNotificationBuilder) other;
			
			merger.mergeRosetta(getOptionExpiry(), o.getOptionExpiry(), this::setOptionExpiry);
			merger.mergeRosetta(getTradeMaturity(), o.getTradeMaturity(), this::setTradeMaturity);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MaturityNotification _that = getType().cast(o);
		
			if (!Objects.equals(optionExpiry, _that.getOptionExpiry())) return false;
			if (!Objects.equals(tradeMaturity, _that.getTradeMaturity())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionExpiry != null ? optionExpiry.hashCode() : 0);
			_result = 31 * _result + (tradeMaturity != null ? tradeMaturity.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MaturityNotificationBuilder {" +
				"optionExpiry=" + this.optionExpiry + ", " +
				"tradeMaturity=" + this.tradeMaturity + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}
