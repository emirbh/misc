package fpml.consolidated.credit.event.notification;

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
import fpml.consolidated.credit.event.notification.meta.CreditEventAcknowledgementMeta;
import fpml.consolidated.doc.UnprocessedElementWrapper;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.Acknowledgement;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.ResponseMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CreditEventAcknowledgement", builder=CreditEventAcknowledgement.CreditEventAcknowledgementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditEventAcknowledgement", model="fpml", builder=CreditEventAcknowledgement.CreditEventAcknowledgementBuilderImpl.class, version="2.1.1")
public interface CreditEventAcknowledgement extends Acknowledgement {

	CreditEventAcknowledgementMeta metaData = new CreditEventAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CreditEventAcknowledgement build();
	
	CreditEventAcknowledgement.CreditEventAcknowledgementBuilder toBuilder();
	
	static CreditEventAcknowledgement.CreditEventAcknowledgementBuilder builder() {
		return new CreditEventAcknowledgement.CreditEventAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEventAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditEventAcknowledgement> getType() {
		return CreditEventAcknowledgement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.class, getOriginalMessage());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventAcknowledgementBuilder extends CreditEventAcknowledgement, Acknowledgement.AcknowledgementBuilder {
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setFpmlVersion(String fpmlVersion);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setActualBuild(Integer actualBuild);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addValidation(Validation validation);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addValidation(Validation validation, int idx);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addValidation(List<? extends Validation> validation);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setValidation(List<? extends Validation> validation);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addParty(Party party);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addParty(Party party, int idx);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addParty(List<? extends Party> party);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setParty(List<? extends Party> party);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addAccount(Account account);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addAccount(Account account, int idx);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addAccount(List<? extends Account> account);
		@Override
		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setAccount(List<? extends Account> account);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.UnprocessedElementWrapperBuilder.class, getOriginalMessage());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		CreditEventAcknowledgement.CreditEventAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEventAcknowledgement  ***********************/
	class CreditEventAcknowledgementImpl extends Acknowledgement.AcknowledgementImpl implements CreditEventAcknowledgement {
		
		protected CreditEventAcknowledgementImpl(CreditEventAcknowledgement.CreditEventAcknowledgementBuilder builder) {
			super(builder);
		}
		
		@Override
		public CreditEventAcknowledgement build() {
			return this;
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder toBuilder() {
			CreditEventAcknowledgement.CreditEventAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEventAcknowledgement.CreditEventAcknowledgementBuilder builder) {
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
			return "CreditEventAcknowledgement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditEventAcknowledgement  ***********************/
	class CreditEventAcknowledgementBuilderImpl extends Acknowledgement.AcknowledgementBuilderImpl implements CreditEventAcknowledgement.CreditEventAcknowledgementBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addValidation(List<? extends Validation> validations) {
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
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setValidation(List<? extends Validation> validations) {
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
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("originalMessage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalMessage")
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper _originalMessage) {
			this.originalMessage = _originalMessage == null ? null : _originalMessage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addParty(List<? extends Party> partys) {
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
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setParty(List<? extends Party> partys) {
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
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder addAccount(List<? extends Account> accounts) {
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
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder setAccount(List<? extends Account> accounts) {
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
		public CreditEventAcknowledgement build() {
			return new CreditEventAcknowledgement.CreditEventAcknowledgementImpl(this);
		}
		
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder prune() {
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
		public CreditEventAcknowledgement.CreditEventAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CreditEventAcknowledgement.CreditEventAcknowledgementBuilder o = (CreditEventAcknowledgement.CreditEventAcknowledgementBuilder) other;
			
			
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
			return "CreditEventAcknowledgementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
