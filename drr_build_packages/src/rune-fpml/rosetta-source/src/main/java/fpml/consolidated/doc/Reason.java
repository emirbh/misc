package fpml.consolidated.doc;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.doc.meta.ReasonMeta;
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
 * Provision A type defining a content model for describing the nature and possible location of a error within a previous message.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a content model for describing the nature and possible location of a error within a previous message.
 *
 */
@RosettaDataType(value="Reason", builder=Reason.ReasonBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Reason", model="fpml", builder=Reason.ReasonBuilderImpl.class, version="2.1.1")
public interface Reason extends RosettaModelObject {

	ReasonMeta metaData = new ReasonMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A machine interpretable error code.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A machine interpretable error code.
	 *
	 */
	ReasonCode getReasonCode();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A value indicating the location of the problem within the subject message.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A value indicating the location of the problem within the subject message.
	 *
	 */
	ProblemLocation getLocation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Plain English text describing the associated error condition
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Plain English text describing the associated error condition
	 *
	 */
	String getDescription();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference identifying a rule within a validation scheme
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference identifying a rule within a validation scheme
	 *
	 */
	Validation getValidationRuleId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Any string of additional data that may help the message processor, for example in a rejection message this might contain a code value or the text of any one of the messages (within a CDATA section).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Any string of additional data that may help the message processor, for example in a rejection message this might contain a code value or the text of any one of the messages (within a CDATA section).
	 *
	 */
	List<? extends AdditionalData> getAdditionalData();

	/*********************** Build Methods  ***********************/
	Reason build();
	
	Reason.ReasonBuilder toBuilder();
	
	static Reason.ReasonBuilder builder() {
		return new Reason.ReasonBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Reason> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Reason> getType() {
		return Reason.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("reasonCode"), processor, ReasonCode.class, getReasonCode());
		processRosetta(path.newSubPath("location"), processor, ProblemLocation.class, getLocation());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("validationRuleId"), processor, Validation.class, getValidationRuleId());
		processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.class, getAdditionalData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReasonBuilder extends Reason, RosettaModelObjectBuilder {
		ReasonCode.ReasonCodeBuilder getOrCreateReasonCode();
		@Override
		ReasonCode.ReasonCodeBuilder getReasonCode();
		ProblemLocation.ProblemLocationBuilder getOrCreateLocation();
		@Override
		ProblemLocation.ProblemLocationBuilder getLocation();
		Validation.ValidationBuilder getOrCreateValidationRuleId();
		@Override
		Validation.ValidationBuilder getValidationRuleId();
		AdditionalData.AdditionalDataBuilder getOrCreateAdditionalData(int index);
		@Override
		List<? extends AdditionalData.AdditionalDataBuilder> getAdditionalData();
		Reason.ReasonBuilder setReasonCode(ReasonCode reasonCode);
		Reason.ReasonBuilder setLocation(ProblemLocation location);
		Reason.ReasonBuilder setDescription(String description);
		Reason.ReasonBuilder setValidationRuleId(Validation validationRuleId);
		Reason.ReasonBuilder addAdditionalData(AdditionalData additionalData);
		Reason.ReasonBuilder addAdditionalData(AdditionalData additionalData, int idx);
		Reason.ReasonBuilder addAdditionalData(List<? extends AdditionalData> additionalData);
		Reason.ReasonBuilder setAdditionalData(List<? extends AdditionalData> additionalData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("reasonCode"), processor, ReasonCode.ReasonCodeBuilder.class, getReasonCode());
			processRosetta(path.newSubPath("location"), processor, ProblemLocation.ProblemLocationBuilder.class, getLocation());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("validationRuleId"), processor, Validation.ValidationBuilder.class, getValidationRuleId());
			processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.AdditionalDataBuilder.class, getAdditionalData());
		}
		

		Reason.ReasonBuilder prune();
	}

	/*********************** Immutable Implementation of Reason  ***********************/
	class ReasonImpl implements Reason {
		private final ReasonCode reasonCode;
		private final ProblemLocation location;
		private final String description;
		private final Validation validationRuleId;
		private final List<? extends AdditionalData> additionalData;
		
		protected ReasonImpl(Reason.ReasonBuilder builder) {
			this.reasonCode = ofNullable(builder.getReasonCode()).map(f->f.build()).orElse(null);
			this.location = ofNullable(builder.getLocation()).map(f->f.build()).orElse(null);
			this.description = builder.getDescription();
			this.validationRuleId = ofNullable(builder.getValidationRuleId()).map(f->f.build()).orElse(null);
			this.additionalData = ofNullable(builder.getAdditionalData()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reasonCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reasonCode")
		public ReasonCode getReasonCode() {
			return reasonCode;
		}
		
		@Override
		@RosettaAttribute("location")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("location")
		public ProblemLocation getLocation() {
			return location;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("validationRuleId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("validationRuleId")
		public Validation getValidationRuleId() {
			return validationRuleId;
		}
		
		@Override
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalData")
		public List<? extends AdditionalData> getAdditionalData() {
			return additionalData;
		}
		
		@Override
		public Reason build() {
			return this;
		}
		
		@Override
		public Reason.ReasonBuilder toBuilder() {
			Reason.ReasonBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Reason.ReasonBuilder builder) {
			ofNullable(getReasonCode()).ifPresent(builder::setReasonCode);
			ofNullable(getLocation()).ifPresent(builder::setLocation);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
			ofNullable(getValidationRuleId()).ifPresent(builder::setValidationRuleId);
			ofNullable(getAdditionalData()).ifPresent(builder::setAdditionalData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Reason _that = getType().cast(o);
		
			if (!Objects.equals(reasonCode, _that.getReasonCode())) return false;
			if (!Objects.equals(location, _that.getLocation())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(validationRuleId, _that.getValidationRuleId())) return false;
			if (!ListEquals.listEquals(additionalData, _that.getAdditionalData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reasonCode != null ? reasonCode.hashCode() : 0);
			_result = 31 * _result + (location != null ? location.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (validationRuleId != null ? validationRuleId.hashCode() : 0);
			_result = 31 * _result + (additionalData != null ? additionalData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Reason {" +
				"reasonCode=" + this.reasonCode + ", " +
				"location=" + this.location + ", " +
				"description=" + this.description + ", " +
				"validationRuleId=" + this.validationRuleId + ", " +
				"additionalData=" + this.additionalData +
			'}';
		}
	}

	/*********************** Builder Implementation of Reason  ***********************/
	class ReasonBuilderImpl implements Reason.ReasonBuilder {
	
		protected ReasonCode.ReasonCodeBuilder reasonCode;
		protected ProblemLocation.ProblemLocationBuilder location;
		protected String description;
		protected Validation.ValidationBuilder validationRuleId;
		protected List<AdditionalData.AdditionalDataBuilder> additionalData = new ArrayList<>();
		
		@Override
		@RosettaAttribute("reasonCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reasonCode")
		public ReasonCode.ReasonCodeBuilder getReasonCode() {
			return reasonCode;
		}
		
		@Override
		public ReasonCode.ReasonCodeBuilder getOrCreateReasonCode() {
			ReasonCode.ReasonCodeBuilder result;
			if (reasonCode!=null) {
				result = reasonCode;
			}
			else {
				result = reasonCode = ReasonCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("location")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("location")
		public ProblemLocation.ProblemLocationBuilder getLocation() {
			return location;
		}
		
		@Override
		public ProblemLocation.ProblemLocationBuilder getOrCreateLocation() {
			ProblemLocation.ProblemLocationBuilder result;
			if (location!=null) {
				result = location;
			}
			else {
				result = location = ProblemLocation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("validationRuleId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("validationRuleId")
		public Validation.ValidationBuilder getValidationRuleId() {
			return validationRuleId;
		}
		
		@Override
		public Validation.ValidationBuilder getOrCreateValidationRuleId() {
			Validation.ValidationBuilder result;
			if (validationRuleId!=null) {
				result = validationRuleId;
			}
			else {
				result = validationRuleId = Validation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalData")
		public List<? extends AdditionalData.AdditionalDataBuilder> getAdditionalData() {
			return additionalData;
		}
		
		@Override
		public AdditionalData.AdditionalDataBuilder getOrCreateAdditionalData(int index) {
			if (additionalData==null) {
				this.additionalData = new ArrayList<>();
			}
			return getIndex(additionalData, index, () -> {
						AdditionalData.AdditionalDataBuilder newAdditionalData = AdditionalData.builder();
						return newAdditionalData;
					});
		}
		
		@RosettaAttribute("reasonCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reasonCode")
		@Override
		public Reason.ReasonBuilder setReasonCode(ReasonCode _reasonCode) {
			this.reasonCode = _reasonCode == null ? null : _reasonCode.toBuilder();
			return this;
		}
		
		@RosettaAttribute("location")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("location")
		@Override
		public Reason.ReasonBuilder setLocation(ProblemLocation _location) {
			this.location = _location == null ? null : _location.toBuilder();
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public Reason.ReasonBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("validationRuleId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("validationRuleId")
		@Override
		public Reason.ReasonBuilder setValidationRuleId(Validation _validationRuleId) {
			this.validationRuleId = _validationRuleId == null ? null : _validationRuleId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalData")
		@Override
		public Reason.ReasonBuilder addAdditionalData(AdditionalData _additionalData) {
			if (_additionalData != null) {
				this.additionalData.add(_additionalData.toBuilder());
			}
			return this;
		}
		
		@Override
		public Reason.ReasonBuilder addAdditionalData(AdditionalData _additionalData, int idx) {
			getIndex(this.additionalData, idx, () -> _additionalData.toBuilder());
			return this;
		}
		
		@Override
		public Reason.ReasonBuilder addAdditionalData(List<? extends AdditionalData> additionalDatas) {
			if (additionalDatas != null) {
				for (final AdditionalData toAdd : additionalDatas) {
					this.additionalData.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("additionalData")
		@Override
		public Reason.ReasonBuilder setAdditionalData(List<? extends AdditionalData> additionalDatas) {
			if (additionalDatas == null) {
				this.additionalData = new ArrayList<>();
			} else {
				this.additionalData = additionalDatas.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Reason build() {
			return new Reason.ReasonImpl(this);
		}
		
		@Override
		public Reason.ReasonBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Reason.ReasonBuilder prune() {
			if (reasonCode!=null && !reasonCode.prune().hasData()) reasonCode = null;
			if (location!=null && !location.prune().hasData()) location = null;
			if (validationRuleId!=null && !validationRuleId.prune().hasData()) validationRuleId = null;
			additionalData = additionalData.stream().filter(b->b!=null).<AdditionalData.AdditionalDataBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReasonCode()!=null && getReasonCode().hasData()) return true;
			if (getLocation()!=null && getLocation().hasData()) return true;
			if (getDescription()!=null) return true;
			if (getValidationRuleId()!=null && getValidationRuleId().hasData()) return true;
			if (getAdditionalData()!=null && getAdditionalData().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Reason.ReasonBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Reason.ReasonBuilder o = (Reason.ReasonBuilder) other;
			
			merger.mergeRosetta(getReasonCode(), o.getReasonCode(), this::setReasonCode);
			merger.mergeRosetta(getLocation(), o.getLocation(), this::setLocation);
			merger.mergeRosetta(getValidationRuleId(), o.getValidationRuleId(), this::setValidationRuleId);
			merger.mergeRosetta(getAdditionalData(), o.getAdditionalData(), this::getOrCreateAdditionalData);
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Reason _that = getType().cast(o);
		
			if (!Objects.equals(reasonCode, _that.getReasonCode())) return false;
			if (!Objects.equals(location, _that.getLocation())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(validationRuleId, _that.getValidationRuleId())) return false;
			if (!ListEquals.listEquals(additionalData, _that.getAdditionalData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reasonCode != null ? reasonCode.hashCode() : 0);
			_result = 31 * _result + (location != null ? location.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (validationRuleId != null ? validationRuleId.hashCode() : 0);
			_result = 31 * _result + (additionalData != null ? additionalData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReasonBuilder {" +
				"reasonCode=" + this.reasonCode + ", " +
				"location=" + this.location + ", " +
				"description=" + this.description + ", " +
				"validationRuleId=" + this.validationRuleId + ", " +
				"additionalData=" + this.additionalData +
			'}';
		}
	}
}
