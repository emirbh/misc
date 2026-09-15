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
import fpml.consolidated.credit.event.notification.meta.CreditEventNotificationRetractedMeta;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NonCorrectableRequestMessage;
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
 * Provision A message type retracting a previous credit event notification.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A message type retracting a previous credit event notification.
 *
 */
@RosettaDataType(value="CreditEventNotificationRetracted", builder=CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditEventNotificationRetracted", model="fpml", builder=CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilderImpl.class, version="2.1.1")
public interface CreditEventNotificationRetracted extends NonCorrectableRequestMessage {

	CreditEventNotificationRetractedMeta metaData = new CreditEventNotificationRetractedMeta();

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
	CreditEventNotificationRetracted build();
	
	CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder toBuilder();
	
	static CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder builder() {
		return new CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEventNotificationRetracted> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditEventNotificationRetracted> getType() {
		return CreditEventNotificationRetracted.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("creditEventNotice"), processor, CreditEventNoticeDocument.class, getCreditEventNotice());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventNotificationRetractedBuilder extends CreditEventNotificationRetracted, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder getOrCreateCreditEventNotice();
		@Override
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder getCreditEventNotice();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setActualBuild(Integer actualBuild);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setHeader(RequestMessageHeader header);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addValidation(Validation validation);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addValidation(Validation validation, int idx);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addValidation(List<? extends Validation> validation);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setValidation(List<? extends Validation> validation);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setCreditEventNotice(CreditEventNoticeDocument creditEventNotice);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addParty(Party party);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addParty(Party party, int idx);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addParty(List<? extends Party> party);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setParty(List<? extends Party> party);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("creditEventNotice"), processor, CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder.class, getCreditEventNotice());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEventNotificationRetracted  ***********************/
	class CreditEventNotificationRetractedImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements CreditEventNotificationRetracted {
		private final CreditEventNoticeDocument creditEventNotice;
		private final List<? extends Party> party;
		
		protected CreditEventNotificationRetractedImpl(CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder builder) {
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
		public CreditEventNotificationRetracted build() {
			return this;
		}
		
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder toBuilder() {
			CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCreditEventNotice()).ifPresent(builder::setCreditEventNotice);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditEventNotificationRetracted _that = getType().cast(o);
		
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
			return "CreditEventNotificationRetracted {" +
				"creditEventNotice=" + this.creditEventNotice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditEventNotificationRetracted  ***********************/
	class CreditEventNotificationRetractedBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl implements CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder {
	
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
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addValidation(List<? extends Validation> validations) {
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
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setValidation(List<? extends Validation> validations) {
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
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setCreditEventNotice(CreditEventNoticeDocument _creditEventNotice) {
			this.creditEventNotice = _creditEventNotice == null ? null : _creditEventNotice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addParty(List<? extends Party> partys) {
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
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setParty(List<? extends Party> partys) {
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
		public CreditEventNotificationRetracted build() {
			return new CreditEventNotificationRetracted.CreditEventNotificationRetractedImpl(this);
		}
		
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder prune() {
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
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder o = (CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder) other;
			
			merger.mergeRosetta(getCreditEventNotice(), o.getCreditEventNotice(), this::setCreditEventNotice);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditEventNotificationRetracted _that = getType().cast(o);
		
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
			return "CreditEventNotificationRetractedBuilder {" +
				"creditEventNotice=" + this.creditEventNotice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
