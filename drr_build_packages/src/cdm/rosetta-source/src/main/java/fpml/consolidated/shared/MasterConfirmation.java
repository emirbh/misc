package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.shared.meta.MasterConfirmationMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision An entity for defining the master confirmation agreement executed between the parties.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An entity for defining the master confirmation agreement executed between the parties.
 *
 */
@RosettaDataType(value="MasterConfirmation", builder=MasterConfirmation.MasterConfirmationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MasterConfirmation", model="fpml", builder=MasterConfirmation.MasterConfirmationBuilderImpl.class, version="2.1.1")
public interface MasterConfirmation extends RosettaModelObject {

	MasterConfirmationMeta metaData = new MasterConfirmationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of master confirmation executed between the parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of master confirmation executed between the parties.
	 *
	 */
	MasterConfirmationType getMasterConfirmationType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date of the confirmation executed between the parties and intended to govern all relevant transactions between those parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date of the confirmation executed between the parties and intended to govern all relevant transactions between those parties.
	 *
	 */
	ZonedDateTime getMasterConfirmationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date that an annex to the master confirmation was executed between the parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date that an annex to the master confirmation was executed between the parties.
	 *
	 */
	ZonedDateTime getMasterConfirmationAnnexDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of master confirmation annex executed between the parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of master confirmation annex executed between the parties.
	 *
	 */
	MasterConfirmationAnnexType getMasterConfirmationAnnexType();

	/*********************** Build Methods  ***********************/
	MasterConfirmation build();
	
	MasterConfirmation.MasterConfirmationBuilder toBuilder();
	
	static MasterConfirmation.MasterConfirmationBuilder builder() {
		return new MasterConfirmation.MasterConfirmationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterConfirmation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MasterConfirmation> getType() {
		return MasterConfirmation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("masterConfirmationType"), processor, MasterConfirmationType.class, getMasterConfirmationType());
		processor.processBasic(path.newSubPath("masterConfirmationDate"), ZonedDateTime.class, getMasterConfirmationDate(), this);
		processor.processBasic(path.newSubPath("masterConfirmationAnnexDate"), ZonedDateTime.class, getMasterConfirmationAnnexDate(), this);
		processRosetta(path.newSubPath("masterConfirmationAnnexType"), processor, MasterConfirmationAnnexType.class, getMasterConfirmationAnnexType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterConfirmationBuilder extends MasterConfirmation, RosettaModelObjectBuilder {
		MasterConfirmationType.MasterConfirmationTypeBuilder getOrCreateMasterConfirmationType();
		@Override
		MasterConfirmationType.MasterConfirmationTypeBuilder getMasterConfirmationType();
		MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder getOrCreateMasterConfirmationAnnexType();
		@Override
		MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder getMasterConfirmationAnnexType();
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationType(MasterConfirmationType masterConfirmationType);
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationDate(ZonedDateTime masterConfirmationDate);
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexDate(ZonedDateTime masterConfirmationAnnexDate);
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexType(MasterConfirmationAnnexType masterConfirmationAnnexType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("masterConfirmationType"), processor, MasterConfirmationType.MasterConfirmationTypeBuilder.class, getMasterConfirmationType());
			processor.processBasic(path.newSubPath("masterConfirmationDate"), ZonedDateTime.class, getMasterConfirmationDate(), this);
			processor.processBasic(path.newSubPath("masterConfirmationAnnexDate"), ZonedDateTime.class, getMasterConfirmationAnnexDate(), this);
			processRosetta(path.newSubPath("masterConfirmationAnnexType"), processor, MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder.class, getMasterConfirmationAnnexType());
		}
		

		MasterConfirmation.MasterConfirmationBuilder prune();
	}

	/*********************** Immutable Implementation of MasterConfirmation  ***********************/
	class MasterConfirmationImpl implements MasterConfirmation {
		private final MasterConfirmationType masterConfirmationType;
		private final ZonedDateTime masterConfirmationDate;
		private final ZonedDateTime masterConfirmationAnnexDate;
		private final MasterConfirmationAnnexType masterConfirmationAnnexType;
		
		protected MasterConfirmationImpl(MasterConfirmation.MasterConfirmationBuilder builder) {
			this.masterConfirmationType = ofNullable(builder.getMasterConfirmationType()).map(f->f.build()).orElse(null);
			this.masterConfirmationDate = builder.getMasterConfirmationDate();
			this.masterConfirmationAnnexDate = builder.getMasterConfirmationAnnexDate();
			this.masterConfirmationAnnexType = ofNullable(builder.getMasterConfirmationAnnexType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("masterConfirmationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterConfirmationType")
		public MasterConfirmationType getMasterConfirmationType() {
			return masterConfirmationType;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterConfirmationDate")
		public ZonedDateTime getMasterConfirmationDate() {
			return masterConfirmationDate;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationAnnexDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterConfirmationAnnexDate")
		public ZonedDateTime getMasterConfirmationAnnexDate() {
			return masterConfirmationAnnexDate;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationAnnexType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterConfirmationAnnexType")
		public MasterConfirmationAnnexType getMasterConfirmationAnnexType() {
			return masterConfirmationAnnexType;
		}
		
		@Override
		public MasterConfirmation build() {
			return this;
		}
		
		@Override
		public MasterConfirmation.MasterConfirmationBuilder toBuilder() {
			MasterConfirmation.MasterConfirmationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterConfirmation.MasterConfirmationBuilder builder) {
			ofNullable(getMasterConfirmationType()).ifPresent(builder::setMasterConfirmationType);
			ofNullable(getMasterConfirmationDate()).ifPresent(builder::setMasterConfirmationDate);
			ofNullable(getMasterConfirmationAnnexDate()).ifPresent(builder::setMasterConfirmationAnnexDate);
			ofNullable(getMasterConfirmationAnnexType()).ifPresent(builder::setMasterConfirmationAnnexType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterConfirmation _that = getType().cast(o);
		
			if (!Objects.equals(masterConfirmationType, _that.getMasterConfirmationType())) return false;
			if (!Objects.equals(masterConfirmationDate, _that.getMasterConfirmationDate())) return false;
			if (!Objects.equals(masterConfirmationAnnexDate, _that.getMasterConfirmationAnnexDate())) return false;
			if (!Objects.equals(masterConfirmationAnnexType, _that.getMasterConfirmationAnnexType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterConfirmationType != null ? masterConfirmationType.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationDate != null ? masterConfirmationDate.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexDate != null ? masterConfirmationAnnexDate.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexType != null ? masterConfirmationAnnexType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterConfirmation {" +
				"masterConfirmationType=" + this.masterConfirmationType + ", " +
				"masterConfirmationDate=" + this.masterConfirmationDate + ", " +
				"masterConfirmationAnnexDate=" + this.masterConfirmationAnnexDate + ", " +
				"masterConfirmationAnnexType=" + this.masterConfirmationAnnexType +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterConfirmation  ***********************/
	class MasterConfirmationBuilderImpl implements MasterConfirmation.MasterConfirmationBuilder {
	
		protected MasterConfirmationType.MasterConfirmationTypeBuilder masterConfirmationType;
		protected ZonedDateTime masterConfirmationDate;
		protected ZonedDateTime masterConfirmationAnnexDate;
		protected MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder masterConfirmationAnnexType;
		
		@Override
		@RosettaAttribute("masterConfirmationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterConfirmationType")
		public MasterConfirmationType.MasterConfirmationTypeBuilder getMasterConfirmationType() {
			return masterConfirmationType;
		}
		
		@Override
		public MasterConfirmationType.MasterConfirmationTypeBuilder getOrCreateMasterConfirmationType() {
			MasterConfirmationType.MasterConfirmationTypeBuilder result;
			if (masterConfirmationType!=null) {
				result = masterConfirmationType;
			}
			else {
				result = masterConfirmationType = MasterConfirmationType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterConfirmationDate")
		public ZonedDateTime getMasterConfirmationDate() {
			return masterConfirmationDate;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationAnnexDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterConfirmationAnnexDate")
		public ZonedDateTime getMasterConfirmationAnnexDate() {
			return masterConfirmationAnnexDate;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationAnnexType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterConfirmationAnnexType")
		public MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder getMasterConfirmationAnnexType() {
			return masterConfirmationAnnexType;
		}
		
		@Override
		public MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder getOrCreateMasterConfirmationAnnexType() {
			MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder result;
			if (masterConfirmationAnnexType!=null) {
				result = masterConfirmationAnnexType;
			}
			else {
				result = masterConfirmationAnnexType = MasterConfirmationAnnexType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("masterConfirmationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterConfirmationType")
		@Override
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationType(MasterConfirmationType _masterConfirmationType) {
			this.masterConfirmationType = _masterConfirmationType == null ? null : _masterConfirmationType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("masterConfirmationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterConfirmationDate")
		@Override
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationDate(ZonedDateTime _masterConfirmationDate) {
			this.masterConfirmationDate = _masterConfirmationDate == null ? null : _masterConfirmationDate;
			return this;
		}
		
		@RosettaAttribute("masterConfirmationAnnexDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterConfirmationAnnexDate")
		@Override
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexDate(ZonedDateTime _masterConfirmationAnnexDate) {
			this.masterConfirmationAnnexDate = _masterConfirmationAnnexDate == null ? null : _masterConfirmationAnnexDate;
			return this;
		}
		
		@RosettaAttribute("masterConfirmationAnnexType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterConfirmationAnnexType")
		@Override
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexType(MasterConfirmationAnnexType _masterConfirmationAnnexType) {
			this.masterConfirmationAnnexType = _masterConfirmationAnnexType == null ? null : _masterConfirmationAnnexType.toBuilder();
			return this;
		}
		
		@Override
		public MasterConfirmation build() {
			return new MasterConfirmation.MasterConfirmationImpl(this);
		}
		
		@Override
		public MasterConfirmation.MasterConfirmationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterConfirmation.MasterConfirmationBuilder prune() {
			if (masterConfirmationType!=null && !masterConfirmationType.prune().hasData()) masterConfirmationType = null;
			if (masterConfirmationAnnexType!=null && !masterConfirmationAnnexType.prune().hasData()) masterConfirmationAnnexType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMasterConfirmationType()!=null && getMasterConfirmationType().hasData()) return true;
			if (getMasterConfirmationDate()!=null) return true;
			if (getMasterConfirmationAnnexDate()!=null) return true;
			if (getMasterConfirmationAnnexType()!=null && getMasterConfirmationAnnexType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterConfirmation.MasterConfirmationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterConfirmation.MasterConfirmationBuilder o = (MasterConfirmation.MasterConfirmationBuilder) other;
			
			merger.mergeRosetta(getMasterConfirmationType(), o.getMasterConfirmationType(), this::setMasterConfirmationType);
			merger.mergeRosetta(getMasterConfirmationAnnexType(), o.getMasterConfirmationAnnexType(), this::setMasterConfirmationAnnexType);
			
			merger.mergeBasic(getMasterConfirmationDate(), o.getMasterConfirmationDate(), this::setMasterConfirmationDate);
			merger.mergeBasic(getMasterConfirmationAnnexDate(), o.getMasterConfirmationAnnexDate(), this::setMasterConfirmationAnnexDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterConfirmation _that = getType().cast(o);
		
			if (!Objects.equals(masterConfirmationType, _that.getMasterConfirmationType())) return false;
			if (!Objects.equals(masterConfirmationDate, _that.getMasterConfirmationDate())) return false;
			if (!Objects.equals(masterConfirmationAnnexDate, _that.getMasterConfirmationAnnexDate())) return false;
			if (!Objects.equals(masterConfirmationAnnexType, _that.getMasterConfirmationAnnexType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterConfirmationType != null ? masterConfirmationType.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationDate != null ? masterConfirmationDate.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexDate != null ? masterConfirmationAnnexDate.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexType != null ? masterConfirmationAnnexType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterConfirmationBuilder {" +
				"masterConfirmationType=" + this.masterConfirmationType + ", " +
				"masterConfirmationDate=" + this.masterConfirmationDate + ", " +
				"masterConfirmationAnnexDate=" + this.masterConfirmationAnnexDate + ", " +
				"masterConfirmationAnnexType=" + this.masterConfirmationAnnexType +
			'}';
		}
	}
}
