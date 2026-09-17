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
import fpml.consolidated.confirmation.processes.meta.CollateralAllocationAcknowledgementMeta;
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
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CollateralAllocationAcknowledgement", builder=CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CollateralAllocationAcknowledgement", model="fpml", builder=CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilderImpl.class, version="2.1.1")
public interface CollateralAllocationAcknowledgement extends Acknowledgement {

	CollateralAllocationAcknowledgementMeta metaData = new CollateralAllocationAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CollateralAllocationAcknowledgement build();
	
	CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder toBuilder();
	
	static CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder builder() {
		return new CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralAllocationAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralAllocationAcknowledgement> getType() {
		return CollateralAllocationAcknowledgement.class;
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
	interface CollateralAllocationAcknowledgementBuilder extends CollateralAllocationAcknowledgement, Acknowledgement.AcknowledgementBuilder {
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setFpmlVersion(String fpmlVersion);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setActualBuild(Integer actualBuild);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addValidation(Validation validation);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addValidation(Validation validation, int idx);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addValidation(List<? extends Validation> validation);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setValidation(List<? extends Validation> validation);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addParty(Party party);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addParty(Party party, int idx);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addParty(List<? extends Party> party);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setParty(List<? extends Party> party);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addAccount(Account account);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addAccount(Account account, int idx);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addAccount(List<? extends Account> account);
		@Override
		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setAccount(List<? extends Account> account);

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
		

		CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralAllocationAcknowledgement  ***********************/
	class CollateralAllocationAcknowledgementImpl extends Acknowledgement.AcknowledgementImpl implements CollateralAllocationAcknowledgement {
		
		protected CollateralAllocationAcknowledgementImpl(CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder builder) {
			super(builder);
		}
		
		@Override
		public CollateralAllocationAcknowledgement build() {
			return this;
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder toBuilder() {
			CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder builder) {
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
			return "CollateralAllocationAcknowledgement {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CollateralAllocationAcknowledgement  ***********************/
	class CollateralAllocationAcknowledgementBuilderImpl extends Acknowledgement.AcknowledgementBuilderImpl implements CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addValidation(List<? extends Validation> validations) {
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
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setValidation(List<? extends Validation> validations) {
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
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper _originalMessage) {
			this.originalMessage = _originalMessage == null ? null : _originalMessage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addParty(List<? extends Party> partys) {
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
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setParty(List<? extends Party> partys) {
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
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder addAccount(List<? extends Account> accounts) {
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
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder setAccount(List<? extends Account> accounts) {
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
		public CollateralAllocationAcknowledgement build() {
			return new CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementImpl(this);
		}
		
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder prune() {
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
		public CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder o = (CollateralAllocationAcknowledgement.CollateralAllocationAcknowledgementBuilder) other;
			
			
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
			return "CollateralAllocationAcknowledgementBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
