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
import fpml.consolidated.business.events.ClearingStatusItem;
import fpml.consolidated.confirmation.processes.meta.ClearingStatusMeta;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NotificationMessage;
import fpml.consolidated.msg.NotificationMessageHeader;
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
 * Provision A message providing the current status of a clearing request. The Clearing Status message is designed to be sent from the Clearing House to the participants. The message sends the clearing status of the trade or the trade package. It’s a centralized model so there is no perspective.
 *
 */
@RosettaDataType(value="ClearingStatus", builder=ClearingStatus.ClearingStatusBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ClearingStatus", model="fpml", builder=ClearingStatus.ClearingStatusBuilderImpl.class, version="2.1.1")
public interface ClearingStatus extends NotificationMessage {

	ClearingStatusMeta metaData = new ClearingStatusMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the status of the clearing process relating to the identified trade.
	 *
	 */
	ClearingStatusItem getClearingStatusItem();
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
	ClearingStatus build();
	
	ClearingStatus.ClearingStatusBuilder toBuilder();
	
	static ClearingStatus.ClearingStatusBuilder builder() {
		return new ClearingStatus.ClearingStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingStatus> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingStatus> getType() {
		return ClearingStatus.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("clearingStatusItem"), processor, ClearingStatusItem.class, getClearingStatusItem());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingStatusBuilder extends ClearingStatus, NotificationMessage.NotificationMessageBuilder {
		ClearingStatusItem.ClearingStatusItemBuilder getOrCreateClearingStatusItem();
		@Override
		ClearingStatusItem.ClearingStatusItemBuilder getClearingStatusItem();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		ClearingStatus.ClearingStatusBuilder setFpmlVersion(String fpmlVersion);
		@Override
		ClearingStatus.ClearingStatusBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		ClearingStatus.ClearingStatusBuilder setActualBuild(Integer actualBuild);
		@Override
		ClearingStatus.ClearingStatusBuilder setHeader(NotificationMessageHeader header);
		@Override
		ClearingStatus.ClearingStatusBuilder addValidation(Validation validation);
		@Override
		ClearingStatus.ClearingStatusBuilder addValidation(Validation validation, int idx);
		@Override
		ClearingStatus.ClearingStatusBuilder addValidation(List<? extends Validation> validation);
		@Override
		ClearingStatus.ClearingStatusBuilder setValidation(List<? extends Validation> validation);
		@Override
		ClearingStatus.ClearingStatusBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		ClearingStatus.ClearingStatusBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		ClearingStatus.ClearingStatusBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		ClearingStatus.ClearingStatusBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ClearingStatus.ClearingStatusBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ClearingStatus.ClearingStatusBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		ClearingStatus.ClearingStatusBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		ClearingStatus.ClearingStatusBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		ClearingStatus.ClearingStatusBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		ClearingStatus.ClearingStatusBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		ClearingStatus.ClearingStatusBuilder setClearingStatusItem(ClearingStatusItem clearingStatusItem);
		ClearingStatus.ClearingStatusBuilder addParty(Party party);
		ClearingStatus.ClearingStatusBuilder addParty(Party party, int idx);
		ClearingStatus.ClearingStatusBuilder addParty(List<? extends Party> party);
		ClearingStatus.ClearingStatusBuilder setParty(List<? extends Party> party);
		ClearingStatus.ClearingStatusBuilder addAccount(Account account);
		ClearingStatus.ClearingStatusBuilder addAccount(Account account, int idx);
		ClearingStatus.ClearingStatusBuilder addAccount(List<? extends Account> account);
		ClearingStatus.ClearingStatusBuilder setAccount(List<? extends Account> account);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("clearingStatusItem"), processor, ClearingStatusItem.ClearingStatusItemBuilder.class, getClearingStatusItem());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		ClearingStatus.ClearingStatusBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingStatus  ***********************/
	class ClearingStatusImpl extends NotificationMessage.NotificationMessageImpl implements ClearingStatus {
		private final ClearingStatusItem clearingStatusItem;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected ClearingStatusImpl(ClearingStatus.ClearingStatusBuilder builder) {
			super(builder);
			this.clearingStatusItem = ofNullable(builder.getClearingStatusItem()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("clearingStatusItem")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingStatusItem")
		public ClearingStatusItem getClearingStatusItem() {
			return clearingStatusItem;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
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
		public ClearingStatus build() {
			return this;
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder toBuilder() {
			ClearingStatus.ClearingStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingStatus.ClearingStatusBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getClearingStatusItem()).ifPresent(builder::setClearingStatusItem);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingStatus _that = getType().cast(o);
		
			if (!Objects.equals(clearingStatusItem, _that.getClearingStatusItem())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (clearingStatusItem != null ? clearingStatusItem.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingStatus {" +
				"clearingStatusItem=" + this.clearingStatusItem + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ClearingStatus  ***********************/
	class ClearingStatusBuilderImpl extends NotificationMessage.NotificationMessageBuilderImpl implements ClearingStatus.ClearingStatusBuilder {
	
		protected ClearingStatusItem.ClearingStatusItemBuilder clearingStatusItem;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("clearingStatusItem")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingStatusItem")
		public ClearingStatusItem.ClearingStatusItemBuilder getClearingStatusItem() {
			return clearingStatusItem;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder getOrCreateClearingStatusItem() {
			ClearingStatusItem.ClearingStatusItemBuilder result;
			if (clearingStatusItem!=null) {
				result = clearingStatusItem;
			}
			else {
				result = clearingStatusItem = ClearingStatusItem.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
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
		public ClearingStatus.ClearingStatusBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public ClearingStatus.ClearingStatusBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public ClearingStatus.ClearingStatusBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public ClearingStatus.ClearingStatusBuilder setHeader(NotificationMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ClearingStatus.ClearingStatusBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder addValidation(List<? extends Validation> validations) {
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
		public ClearingStatus.ClearingStatusBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public ClearingStatus.ClearingStatusBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ClearingStatus.ClearingStatusBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ClearingStatus.ClearingStatusBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ClearingStatus.ClearingStatusBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ClearingStatus.ClearingStatusBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public ClearingStatus.ClearingStatusBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("clearingStatusItem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingStatusItem")
		@Override
		public ClearingStatus.ClearingStatusBuilder setClearingStatusItem(ClearingStatusItem _clearingStatusItem) {
			this.clearingStatusItem = _clearingStatusItem == null ? null : _clearingStatusItem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public ClearingStatus.ClearingStatusBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("party")
		@Override
		public ClearingStatus.ClearingStatusBuilder setParty(List<? extends Party> partys) {
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
		public ClearingStatus.ClearingStatusBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder addAccount(List<? extends Account> accounts) {
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
		public ClearingStatus.ClearingStatusBuilder setAccount(List<? extends Account> accounts) {
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
		public ClearingStatus build() {
			return new ClearingStatus.ClearingStatusImpl(this);
		}
		
		@Override
		public ClearingStatus.ClearingStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingStatus.ClearingStatusBuilder prune() {
			super.prune();
			if (clearingStatusItem!=null && !clearingStatusItem.prune().hasData()) clearingStatusItem = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getClearingStatusItem()!=null && getClearingStatusItem().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingStatus.ClearingStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ClearingStatus.ClearingStatusBuilder o = (ClearingStatus.ClearingStatusBuilder) other;
			
			merger.mergeRosetta(getClearingStatusItem(), o.getClearingStatusItem(), this::setClearingStatusItem);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingStatus _that = getType().cast(o);
		
			if (!Objects.equals(clearingStatusItem, _that.getClearingStatusItem())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (clearingStatusItem != null ? clearingStatusItem.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingStatusBuilder {" +
				"clearingStatusItem=" + this.clearingStatusItem + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}
