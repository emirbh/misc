package fpml.consolidated.credit.event.notification;

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
import fpml.consolidated.credit.event.notification.meta.CreditEventNotificationMeta;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrectableRequestMessage;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
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
 * version "recordkeeping-5.13"
 *
 * Provision A message type defining the ISDA defined Credit Event Notice. ISDA defines it as an irrevocable notice from a Notifying Party to the other party that describes a Credit Event that occurred. A Credit Event Notice must contain detail of the facts relevant to the determination that a Credit Event has occurred.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A message type defining the ISDA defined Credit Event Notice. ISDA defines it as an irrevocable notice from a Notifying Party to the other party that describes a Credit Event that occurred. A Credit Event Notice must contain detail of the facts relevant to the determination that a Credit Event has occurred.
 *
 */
@RosettaDataType(value="CreditEventNotification", builder=CreditEventNotification.CreditEventNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditEventNotification", model="fpml", builder=CreditEventNotification.CreditEventNotificationBuilderImpl.class, version="2.1.1")
public interface CreditEventNotification extends CorrectableRequestMessage {

	CreditEventNotificationMeta metaData = new CreditEventNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	CreditEventNoticeDocument getCreditEventNotice();
	/**
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
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	CreditEventNotification build();
	
	CreditEventNotification.CreditEventNotificationBuilder toBuilder();
	
	static CreditEventNotification.CreditEventNotificationBuilder builder() {
		return new CreditEventNotification.CreditEventNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEventNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditEventNotification> getType() {
		return CreditEventNotification.class;
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
		processRosetta(path.newSubPath("creditEventNotice"), processor, CreditEventNoticeDocument.class, getCreditEventNotice());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventNotificationBuilder extends CreditEventNotification, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder getOrCreateCreditEventNotice();
		@Override
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder getCreditEventNotice();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		CreditEventNotification.CreditEventNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder addValidation(Validation validation);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		CreditEventNotification.CreditEventNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		CreditEventNotification.CreditEventNotificationBuilder setCreditEventNotice(CreditEventNoticeDocument creditEventNotice);
		CreditEventNotification.CreditEventNotificationBuilder addParty(Party party);
		CreditEventNotification.CreditEventNotificationBuilder addParty(Party party, int idx);
		CreditEventNotification.CreditEventNotificationBuilder addParty(List<? extends Party> party);
		CreditEventNotification.CreditEventNotificationBuilder setParty(List<? extends Party> party);

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
			processRosetta(path.newSubPath("creditEventNotice"), processor, CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder.class, getCreditEventNotice());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		CreditEventNotification.CreditEventNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEventNotification  ***********************/
	class CreditEventNotificationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements CreditEventNotification {
		private final CreditEventNoticeDocument creditEventNotice;
		private final List<? extends Party> party;
		
		protected CreditEventNotificationImpl(CreditEventNotification.CreditEventNotificationBuilder builder) {
			super(builder);
			this.creditEventNotice = ofNullable(builder.getCreditEventNotice()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("creditEventNotice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEventNotice")
		public CreditEventNoticeDocument getCreditEventNotice() {
			return creditEventNotice;
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
		public CreditEventNotification build() {
			return this;
		}
		
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder toBuilder() {
			CreditEventNotification.CreditEventNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEventNotification.CreditEventNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCreditEventNotice()).ifPresent(builder::setCreditEventNotice);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditEventNotification _that = getType().cast(o);
		
			if (!Objects.equals(creditEventNotice, _that.getCreditEventNotice())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (creditEventNotice != null ? creditEventNotice.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventNotification {" +
				"creditEventNotice=" + this.creditEventNotice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditEventNotification  ***********************/
	class CreditEventNotificationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl implements CreditEventNotification.CreditEventNotificationBuilder {
	
		protected CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder creditEventNotice;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("creditEventNotice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEventNotice")
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder getCreditEventNotice() {
			return creditEventNotice;
		}
		
		@Override
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder getOrCreateCreditEventNotice() {
			CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder result;
			if (creditEventNotice!=null) {
				result = creditEventNotice;
			}
			else {
				result = creditEventNotice = CreditEventNoticeDocument.builder();
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
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addValidation(List<? extends Validation> validations) {
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
		public CreditEventNotification.CreditEventNotificationBuilder setValidation(List<? extends Validation> validations) {
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
		public CreditEventNotification.CreditEventNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CreditEventNotification.CreditEventNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CreditEventNotification.CreditEventNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public CreditEventNotification.CreditEventNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("creditEventNotice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditEventNotice")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder setCreditEventNotice(CreditEventNoticeDocument _creditEventNotice) {
			this.creditEventNotice = _creditEventNotice == null ? null : _creditEventNotice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addParty(List<? extends Party> partys) {
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
		public CreditEventNotification.CreditEventNotificationBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CreditEventNotification build() {
			return new CreditEventNotification.CreditEventNotificationImpl(this);
		}
		
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder prune() {
			super.prune();
			if (creditEventNotice!=null && !creditEventNotice.prune().hasData()) creditEventNotice = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCreditEventNotice()!=null && getCreditEventNotice().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CreditEventNotification.CreditEventNotificationBuilder o = (CreditEventNotification.CreditEventNotificationBuilder) other;
			
			merger.mergeRosetta(getCreditEventNotice(), o.getCreditEventNotice(), this::setCreditEventNotice);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditEventNotification _that = getType().cast(o);
		
			if (!Objects.equals(creditEventNotice, _that.getCreditEventNotice())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (creditEventNotice != null ? creditEventNotice.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventNotificationBuilder {" +
				"creditEventNotice=" + this.creditEventNotice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
