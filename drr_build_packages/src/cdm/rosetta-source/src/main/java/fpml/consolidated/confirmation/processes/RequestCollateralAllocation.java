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
import fpml.consolidated.confirmation.processes.meta.RequestCollateralAllocationMeta;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrectableRequestMessage;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProposedCollateralAllocation;
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
 * Provision 
 *
 */
@RosettaDataType(value="RequestCollateralAllocation", builder=RequestCollateralAllocation.RequestCollateralAllocationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequestCollateralAllocation", model="fpml", builder=RequestCollateralAllocation.RequestCollateralAllocationBuilderImpl.class, version="2.1.1")
public interface RequestCollateralAllocation extends CorrectableRequestMessage {

	RequestCollateralAllocationMeta metaData = new RequestCollateralAllocationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the service to which the message applies
	 *
	 */
	String getServiceName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of change requested for the collateral allocation.
	 *
	 */
	RequestedCollateralAllocationAction getRequestedAction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party paying the margin / issuing the allocation request.
	 *
	 */
	PartyReference getCollateralGiverPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allocation details
	 *
	 */
	List<? extends ProposedCollateralAllocation> getCollateralAllocation();
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
	RequestCollateralAllocation build();
	
	RequestCollateralAllocation.RequestCollateralAllocationBuilder toBuilder();
	
	static RequestCollateralAllocation.RequestCollateralAllocationBuilder builder() {
		return new RequestCollateralAllocation.RequestCollateralAllocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestCollateralAllocation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequestCollateralAllocation> getType() {
		return RequestCollateralAllocation.class;
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
		processor.processBasic(path.newSubPath("serviceName"), String.class, getServiceName(), this);
		processRosetta(path.newSubPath("requestedAction"), processor, RequestedCollateralAllocationAction.class, getRequestedAction());
		processRosetta(path.newSubPath("collateralGiverPartyReference"), processor, PartyReference.class, getCollateralGiverPartyReference());
		processRosetta(path.newSubPath("collateralAllocation"), processor, ProposedCollateralAllocation.class, getCollateralAllocation());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestCollateralAllocationBuilder extends RequestCollateralAllocation, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder getOrCreateRequestedAction();
		@Override
		RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder getRequestedAction();
		PartyReference.PartyReferenceBuilder getOrCreateCollateralGiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getCollateralGiverPartyReference();
		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder getOrCreateCollateralAllocation(int index);
		@Override
		List<? extends ProposedCollateralAllocation.ProposedCollateralAllocationBuilder> getCollateralAllocation();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setActualBuild(Integer actualBuild);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setHeader(RequestMessageHeader header);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addValidation(Validation validation);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addValidation(Validation validation, int idx);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addValidation(List<? extends Validation> validation);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setValidation(List<? extends Validation> validation);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setServiceName(String serviceName);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setRequestedAction(RequestedCollateralAllocationAction requestedAction);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setCollateralGiverPartyReference(PartyReference collateralGiverPartyReference);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addCollateralAllocation(ProposedCollateralAllocation collateralAllocation);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addCollateralAllocation(ProposedCollateralAllocation collateralAllocation, int idx);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addCollateralAllocation(List<? extends ProposedCollateralAllocation> collateralAllocation);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setCollateralAllocation(List<? extends ProposedCollateralAllocation> collateralAllocation);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addParty(Party party);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addParty(Party party, int idx);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addParty(List<? extends Party> party);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setParty(List<? extends Party> party);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addAccount(Account account);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addAccount(Account account, int idx);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addAccount(List<? extends Account> account);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setAccount(List<? extends Account> account);

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
			processor.processBasic(path.newSubPath("serviceName"), String.class, getServiceName(), this);
			processRosetta(path.newSubPath("requestedAction"), processor, RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder.class, getRequestedAction());
			processRosetta(path.newSubPath("collateralGiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getCollateralGiverPartyReference());
			processRosetta(path.newSubPath("collateralAllocation"), processor, ProposedCollateralAllocation.ProposedCollateralAllocationBuilder.class, getCollateralAllocation());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		RequestCollateralAllocation.RequestCollateralAllocationBuilder prune();
	}

	/*********************** Immutable Implementation of RequestCollateralAllocation  ***********************/
	class RequestCollateralAllocationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements RequestCollateralAllocation {
		private final String serviceName;
		private final RequestedCollateralAllocationAction requestedAction;
		private final PartyReference collateralGiverPartyReference;
		private final List<? extends ProposedCollateralAllocation> collateralAllocation;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected RequestCollateralAllocationImpl(RequestCollateralAllocation.RequestCollateralAllocationBuilder builder) {
			super(builder);
			this.serviceName = builder.getServiceName();
			this.requestedAction = ofNullable(builder.getRequestedAction()).map(f->f.build()).orElse(null);
			this.collateralGiverPartyReference = ofNullable(builder.getCollateralGiverPartyReference()).map(f->f.build()).orElse(null);
			this.collateralAllocation = ofNullable(builder.getCollateralAllocation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("serviceName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("serviceName")
		public String getServiceName() {
			return serviceName;
		}
		
		@Override
		@RosettaAttribute("requestedAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requestedAction")
		public RequestedCollateralAllocationAction getRequestedAction() {
			return requestedAction;
		}
		
		@Override
		@RosettaAttribute("collateralGiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralGiverPartyReference")
		public PartyReference getCollateralGiverPartyReference() {
			return collateralGiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("collateralAllocation")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("collateralAllocation")
		public List<? extends ProposedCollateralAllocation> getCollateralAllocation() {
			return collateralAllocation;
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
		public RequestCollateralAllocation build() {
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder toBuilder() {
			RequestCollateralAllocation.RequestCollateralAllocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestCollateralAllocation.RequestCollateralAllocationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getServiceName()).ifPresent(builder::setServiceName);
			ofNullable(getRequestedAction()).ifPresent(builder::setRequestedAction);
			ofNullable(getCollateralGiverPartyReference()).ifPresent(builder::setCollateralGiverPartyReference);
			ofNullable(getCollateralAllocation()).ifPresent(builder::setCollateralAllocation);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestCollateralAllocation _that = getType().cast(o);
		
			if (!Objects.equals(serviceName, _that.getServiceName())) return false;
			if (!Objects.equals(requestedAction, _that.getRequestedAction())) return false;
			if (!Objects.equals(collateralGiverPartyReference, _that.getCollateralGiverPartyReference())) return false;
			if (!ListEquals.listEquals(collateralAllocation, _that.getCollateralAllocation())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (serviceName != null ? serviceName.hashCode() : 0);
			_result = 31 * _result + (requestedAction != null ? requestedAction.hashCode() : 0);
			_result = 31 * _result + (collateralGiverPartyReference != null ? collateralGiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (collateralAllocation != null ? collateralAllocation.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestCollateralAllocation {" +
				"serviceName=" + this.serviceName + ", " +
				"requestedAction=" + this.requestedAction + ", " +
				"collateralGiverPartyReference=" + this.collateralGiverPartyReference + ", " +
				"collateralAllocation=" + this.collateralAllocation + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestCollateralAllocation  ***********************/
	class RequestCollateralAllocationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl implements RequestCollateralAllocation.RequestCollateralAllocationBuilder {
	
		protected String serviceName;
		protected RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder requestedAction;
		protected PartyReference.PartyReferenceBuilder collateralGiverPartyReference;
		protected List<ProposedCollateralAllocation.ProposedCollateralAllocationBuilder> collateralAllocation = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("serviceName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("serviceName")
		public String getServiceName() {
			return serviceName;
		}
		
		@Override
		@RosettaAttribute("requestedAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requestedAction")
		public RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder getRequestedAction() {
			return requestedAction;
		}
		
		@Override
		public RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder getOrCreateRequestedAction() {
			RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder result;
			if (requestedAction!=null) {
				result = requestedAction;
			}
			else {
				result = requestedAction = RequestedCollateralAllocationAction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralGiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralGiverPartyReference")
		public PartyReference.PartyReferenceBuilder getCollateralGiverPartyReference() {
			return collateralGiverPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateCollateralGiverPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (collateralGiverPartyReference!=null) {
				result = collateralGiverPartyReference;
			}
			else {
				result = collateralGiverPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralAllocation")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("collateralAllocation")
		public List<? extends ProposedCollateralAllocation.ProposedCollateralAllocationBuilder> getCollateralAllocation() {
			return collateralAllocation;
		}
		
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder getOrCreateCollateralAllocation(int index) {
			if (collateralAllocation==null) {
				this.collateralAllocation = new ArrayList<>();
			}
			return getIndex(collateralAllocation, index, () -> {
						ProposedCollateralAllocation.ProposedCollateralAllocationBuilder newCollateralAllocation = ProposedCollateralAllocation.builder();
						return newCollateralAllocation;
					});
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
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addValidation(List<? extends Validation> validations) {
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
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setValidation(List<? extends Validation> validations) {
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
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("serviceName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("serviceName")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setServiceName(String _serviceName) {
			this.serviceName = _serviceName == null ? null : _serviceName;
			return this;
		}
		
		@RosettaAttribute("requestedAction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("requestedAction")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setRequestedAction(RequestedCollateralAllocationAction _requestedAction) {
			this.requestedAction = _requestedAction == null ? null : _requestedAction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralGiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("collateralGiverPartyReference")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setCollateralGiverPartyReference(PartyReference _collateralGiverPartyReference) {
			this.collateralGiverPartyReference = _collateralGiverPartyReference == null ? null : _collateralGiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralAllocation")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("collateralAllocation")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addCollateralAllocation(ProposedCollateralAllocation _collateralAllocation) {
			if (_collateralAllocation != null) {
				this.collateralAllocation.add(_collateralAllocation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addCollateralAllocation(ProposedCollateralAllocation _collateralAllocation, int idx) {
			getIndex(this.collateralAllocation, idx, () -> _collateralAllocation.toBuilder());
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addCollateralAllocation(List<? extends ProposedCollateralAllocation> collateralAllocations) {
			if (collateralAllocations != null) {
				for (final ProposedCollateralAllocation toAdd : collateralAllocations) {
					this.collateralAllocation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("collateralAllocation")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("collateralAllocation")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setCollateralAllocation(List<? extends ProposedCollateralAllocation> collateralAllocations) {
			if (collateralAllocations == null) {
				this.collateralAllocation = new ArrayList<>();
			} else {
				this.collateralAllocation = collateralAllocations.stream()
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
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addParty(List<? extends Party> partys) {
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
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setParty(List<? extends Party> partys) {
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
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addAccount(List<? extends Account> accounts) {
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
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setAccount(List<? extends Account> accounts) {
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
		public RequestCollateralAllocation build() {
			return new RequestCollateralAllocation.RequestCollateralAllocationImpl(this);
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder prune() {
			super.prune();
			if (requestedAction!=null && !requestedAction.prune().hasData()) requestedAction = null;
			if (collateralGiverPartyReference!=null && !collateralGiverPartyReference.prune().hasData()) collateralGiverPartyReference = null;
			collateralAllocation = collateralAllocation.stream().filter(b->b!=null).<ProposedCollateralAllocation.ProposedCollateralAllocationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getServiceName()!=null) return true;
			if (getRequestedAction()!=null && getRequestedAction().hasData()) return true;
			if (getCollateralGiverPartyReference()!=null && getCollateralGiverPartyReference().hasData()) return true;
			if (getCollateralAllocation()!=null && getCollateralAllocation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RequestCollateralAllocation.RequestCollateralAllocationBuilder o = (RequestCollateralAllocation.RequestCollateralAllocationBuilder) other;
			
			merger.mergeRosetta(getRequestedAction(), o.getRequestedAction(), this::setRequestedAction);
			merger.mergeRosetta(getCollateralGiverPartyReference(), o.getCollateralGiverPartyReference(), this::setCollateralGiverPartyReference);
			merger.mergeRosetta(getCollateralAllocation(), o.getCollateralAllocation(), this::getOrCreateCollateralAllocation);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			merger.mergeBasic(getServiceName(), o.getServiceName(), this::setServiceName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestCollateralAllocation _that = getType().cast(o);
		
			if (!Objects.equals(serviceName, _that.getServiceName())) return false;
			if (!Objects.equals(requestedAction, _that.getRequestedAction())) return false;
			if (!Objects.equals(collateralGiverPartyReference, _that.getCollateralGiverPartyReference())) return false;
			if (!ListEquals.listEquals(collateralAllocation, _that.getCollateralAllocation())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (serviceName != null ? serviceName.hashCode() : 0);
			_result = 31 * _result + (requestedAction != null ? requestedAction.hashCode() : 0);
			_result = 31 * _result + (collateralGiverPartyReference != null ? collateralGiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (collateralAllocation != null ? collateralAllocation.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestCollateralAllocationBuilder {" +
				"serviceName=" + this.serviceName + ", " +
				"requestedAction=" + this.requestedAction + ", " +
				"collateralGiverPartyReference=" + this.collateralGiverPartyReference + ", " +
				"collateralAllocation=" + this.collateralAllocation + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}
