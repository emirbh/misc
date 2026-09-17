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
import fpml.consolidated.business.events.TradeReferenceInformation;
import fpml.consolidated.confirmation.processes.meta.ExecutionAcknowledgementMeta;
import fpml.consolidated.doc.UnprocessedElementWrapper;
import fpml.consolidated.doc.Validation;
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
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="ExecutionAcknowledgement", builder=ExecutionAcknowledgement.ExecutionAcknowledgementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExecutionAcknowledgement", model="fpml", builder=ExecutionAcknowledgement.ExecutionAcknowledgementBuilderImpl.class, version="2.1.1")
public interface ExecutionAcknowledgement extends EventRequestAcknowledgement {

	ExecutionAcknowledgementMeta metaData = new ExecutionAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ExecutionAcknowledgement build();
	
	ExecutionAcknowledgement.ExecutionAcknowledgementBuilder toBuilder();
	
	static ExecutionAcknowledgement.ExecutionAcknowledgementBuilder builder() {
		return new ExecutionAcknowledgement.ExecutionAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExecutionAcknowledgement> getType() {
		return ExecutionAcknowledgement.class;
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
		processRosetta(path.newSubPath("tradeReferenceInformation"), processor, TradeReferenceInformation.class, getTradeReferenceInformation());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutionAcknowledgementBuilder extends ExecutionAcknowledgement, EventRequestAcknowledgement.EventRequestAcknowledgementBuilder {
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setFpmlVersion(String fpmlVersion);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setActualBuild(Integer actualBuild);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addValidation(Validation validation);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addValidation(Validation validation, int idx);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addValidation(List<? extends Validation> validation);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setValidation(List<? extends Validation> validation);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setTradeReferenceInformation(TradeReferenceInformation tradeReferenceInformation);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addParty(Party party);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addParty(Party party, int idx);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addParty(List<? extends Party> party);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setParty(List<? extends Party> party);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addAccount(Account account);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addAccount(Account account, int idx);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addAccount(List<? extends Account> account);
		@Override
		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setAccount(List<? extends Account> account);

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
			processRosetta(path.newSubPath("tradeReferenceInformation"), processor, TradeReferenceInformation.TradeReferenceInformationBuilder.class, getTradeReferenceInformation());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		ExecutionAcknowledgement.ExecutionAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionAcknowledgement  ***********************/
	class ExecutionAcknowledgementImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementImpl implements ExecutionAcknowledgement {
		
		protected ExecutionAcknowledgementImpl(ExecutionAcknowledgement.ExecutionAcknowledgementBuilder builder) {
			super(builder);
		}
		
		@Override
		public ExecutionAcknowledgement build() {
			return this;
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder toBuilder() {
			ExecutionAcknowledgement.ExecutionAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionAcknowledgement.ExecutionAcknowledgementBuilder builder) {
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
			return "ExecutionAcknowledgement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExecutionAcknowledgement  ***********************/
	class ExecutionAcknowledgementBuilderImpl extends EventRequestAcknowledgement.EventRequestAcknowledgementBuilderImpl implements ExecutionAcknowledgement.ExecutionAcknowledgementBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addValidation(List<? extends Validation> validations) {
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
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setValidation(List<? extends Validation> validations) {
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
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper _originalMessage) {
			this.originalMessage = _originalMessage == null ? null : _originalMessage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeReferenceInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeReferenceInformation")
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setTradeReferenceInformation(TradeReferenceInformation _tradeReferenceInformation) {
			this.tradeReferenceInformation = _tradeReferenceInformation == null ? null : _tradeReferenceInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addParty(List<? extends Party> partys) {
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
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setParty(List<? extends Party> partys) {
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
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder addAccount(List<? extends Account> accounts) {
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
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder setAccount(List<? extends Account> accounts) {
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
		public ExecutionAcknowledgement build() {
			return new ExecutionAcknowledgement.ExecutionAcknowledgementImpl(this);
		}
		
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder prune() {
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
		public ExecutionAcknowledgement.ExecutionAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ExecutionAcknowledgement.ExecutionAcknowledgementBuilder o = (ExecutionAcknowledgement.ExecutionAcknowledgementBuilder) other;
			
			
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
			return "ExecutionAcknowledgementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
