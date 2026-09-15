package fpml.consolidated.loan;

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
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.meta.AbstractLoanAllocationNotificationMeta;
import fpml.consolidated.msg.CorrectableRequestMessage;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
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
 * Provision An underlying abstract structure for all syndicated loan trade allocation notifications; the wrapper for events which occur through the life-cycle of a loan allocation.
 *
 */
@RosettaDataType(value="AbstractLoanAllocationNotification", builder=AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractLoanAllocationNotification", model="fpml", builder=AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilderImpl.class, version="2.1.1")
public interface AbstractLoanAllocationNotification extends CorrectableRequestMessage {

	AbstractLoanAllocationNotificationMeta metaData = new AbstractLoanAllocationNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The business date on which the notice is valid (and was communicated).
	 *
	 */
	ZonedDateTime getNoticeDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party sending the notification.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The role of the party that is sending the notification.
	 *
	 */
	LoanTradingPartyRole getRole();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This structure should NOT be used for LoanTradeNotification as there are no allocation objects that can be referenced within the notification structure.
	 *
	 */
	List<? extends LoanAllocationPayment> getPayment();

	/*********************** Build Methods  ***********************/
	AbstractLoanAllocationNotification build();
	
	AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder toBuilder();
	
	static AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder builder() {
		return new AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanAllocationNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractLoanAllocationNotification> getType() {
		return AbstractLoanAllocationNotification.class;
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
		processor.processBasic(path.newSubPath("noticeDate"), ZonedDateTime.class, getNoticeDate(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.class, getRole());
		processRosetta(path.newSubPath("payment"), processor, LoanAllocationPayment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanAllocationNotificationBuilder extends AbstractLoanAllocationNotification, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		LoanTradingPartyRole.LoanTradingPartyRoleBuilder getOrCreateRole();
		@Override
		LoanTradingPartyRole.LoanTradingPartyRoleBuilder getRole();
		LoanAllocationPayment.LoanAllocationPaymentBuilder getOrCreatePayment(int index);
		@Override
		List<? extends LoanAllocationPayment.LoanAllocationPaymentBuilder> getPayment();
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addValidation(Validation validation);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setNoticeDate(ZonedDateTime noticeDate);
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setPartyReference(PartyReference partyReference);
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setRole(LoanTradingPartyRole role);
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addPayment(LoanAllocationPayment payment);
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addPayment(LoanAllocationPayment payment, int idx);
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addPayment(List<? extends LoanAllocationPayment> payment);
		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setPayment(List<? extends LoanAllocationPayment> payment);

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
			processor.processBasic(path.newSubPath("noticeDate"), ZonedDateTime.class, getNoticeDate(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.LoanTradingPartyRoleBuilder.class, getRole());
			processRosetta(path.newSubPath("payment"), processor, LoanAllocationPayment.LoanAllocationPaymentBuilder.class, getPayment());
		}
		

		AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanAllocationNotification  ***********************/
	class AbstractLoanAllocationNotificationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements AbstractLoanAllocationNotification {
		private final ZonedDateTime noticeDate;
		private final PartyReference partyReference;
		private final LoanTradingPartyRole role;
		private final List<? extends LoanAllocationPayment> payment;
		
		protected AbstractLoanAllocationNotificationImpl(AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder builder) {
			super(builder);
			this.noticeDate = builder.getNoticeDate();
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.role = ofNullable(builder.getRole()).map(f->f.build()).orElse(null);
			this.payment = ofNullable(builder.getPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("noticeDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("noticeDate")
		public ZonedDateTime getNoticeDate() {
			return noticeDate;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("role")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("role")
		public LoanTradingPartyRole getRole() {
			return role;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("payment")
		public List<? extends LoanAllocationPayment> getPayment() {
			return payment;
		}
		
		@Override
		public AbstractLoanAllocationNotification build() {
			return this;
		}
		
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder toBuilder() {
			AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNoticeDate()).ifPresent(builder::setNoticeDate);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getRole()).ifPresent(builder::setRole);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanAllocationNotification _that = getType().cast(o);
		
			if (!Objects.equals(noticeDate, _that.getNoticeDate())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (noticeDate != null ? noticeDate.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationNotification {" +
				"noticeDate=" + this.noticeDate + ", " +
				"partyReference=" + this.partyReference + ", " +
				"role=" + this.role + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanAllocationNotification  ***********************/
	class AbstractLoanAllocationNotificationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl implements AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder {
	
		protected ZonedDateTime noticeDate;
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected LoanTradingPartyRole.LoanTradingPartyRoleBuilder role;
		protected List<LoanAllocationPayment.LoanAllocationPaymentBuilder> payment = new ArrayList<>();
		
		@Override
		@RosettaAttribute("noticeDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("noticeDate")
		public ZonedDateTime getNoticeDate() {
			return noticeDate;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("role")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("role")
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder getRole() {
			return role;
		}
		
		@Override
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder getOrCreateRole() {
			LoanTradingPartyRole.LoanTradingPartyRoleBuilder result;
			if (role!=null) {
				result = role;
			}
			else {
				result = role = LoanTradingPartyRole.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("payment")
		public List<? extends LoanAllocationPayment.LoanAllocationPaymentBuilder> getPayment() {
			return payment;
		}
		
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder getOrCreatePayment(int index) {
			if (payment==null) {
				this.payment = new ArrayList<>();
			}
			return getIndex(payment, index, () -> {
						LoanAllocationPayment.LoanAllocationPaymentBuilder newPayment = LoanAllocationPayment.builder();
						return newPayment;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addValidation(List<? extends Validation> validations) {
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
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setValidation(List<? extends Validation> validations) {
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
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("noticeDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("noticeDate")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setNoticeDate(ZonedDateTime _noticeDate) {
			this.noticeDate = _noticeDate == null ? null : _noticeDate;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("role")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("role")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setRole(LoanTradingPartyRole _role) {
			this.role = _role == null ? null : _role.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addPayment(LoanAllocationPayment _payment) {
			if (_payment != null) {
				this.payment.add(_payment.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addPayment(LoanAllocationPayment _payment, int idx) {
			getIndex(this.payment, idx, () -> _payment.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder addPayment(List<? extends LoanAllocationPayment> payments) {
			if (payments != null) {
				for (final LoanAllocationPayment toAdd : payments) {
					this.payment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder setPayment(List<? extends LoanAllocationPayment> payments) {
			if (payments == null) {
				this.payment = new ArrayList<>();
			} else {
				this.payment = payments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AbstractLoanAllocationNotification build() {
			return new AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationImpl(this);
		}
		
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder prune() {
			super.prune();
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (role!=null && !role.prune().hasData()) role = null;
			payment = payment.stream().filter(b->b!=null).<LoanAllocationPayment.LoanAllocationPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNoticeDate()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getRole()!=null && getRole().hasData()) return true;
			if (getPayment()!=null && getPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder o = (AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getRole(), o.getRole(), this::setRole);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::getOrCreatePayment);
			
			merger.mergeBasic(getNoticeDate(), o.getNoticeDate(), this::setNoticeDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanAllocationNotification _that = getType().cast(o);
		
			if (!Objects.equals(noticeDate, _that.getNoticeDate())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (noticeDate != null ? noticeDate.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationNotificationBuilder {" +
				"noticeDate=" + this.noticeDate + ", " +
				"partyReference=" + this.partyReference + ", " +
				"role=" + this.role + ", " +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}
}
