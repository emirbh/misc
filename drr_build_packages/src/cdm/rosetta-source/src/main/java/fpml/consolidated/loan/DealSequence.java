package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.loan.meta.DealSequenceMeta;
import java.util.Objects;

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
@RosettaDataType(value="DealSequence", builder=DealSequence.DealSequenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DealSequence", model="fpml", builder=DealSequence.DealSequenceBuilderImpl.class, version="2.1.1")
public interface DealSequence extends RosettaModelObject {

	DealSequenceMeta metaData = new DealSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AbstractFacility getFacilityGroup();

	/*********************** Build Methods  ***********************/
	DealSequence build();
	
	DealSequence.DealSequenceBuilder toBuilder();
	
	static DealSequence.DealSequenceBuilder builder() {
		return new DealSequence.DealSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DealSequence> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DealSequence> getType() {
		return DealSequence.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityGroup"), processor, AbstractFacility.class, getFacilityGroup());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DealSequenceBuilder extends DealSequence, RosettaModelObjectBuilder {
		AbstractFacility.AbstractFacilityBuilder getOrCreateFacilityGroup();
		@Override
		AbstractFacility.AbstractFacilityBuilder getFacilityGroup();
		DealSequence.DealSequenceBuilder setFacilityGroup(AbstractFacility facilityGroup);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityGroup"), processor, AbstractFacility.AbstractFacilityBuilder.class, getFacilityGroup());
		}
		

		DealSequence.DealSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of DealSequence  ***********************/
	class DealSequenceImpl implements DealSequence {
		private final AbstractFacility facilityGroup;
		
		protected DealSequenceImpl(DealSequence.DealSequenceBuilder builder) {
			this.facilityGroup = ofNullable(builder.getFacilityGroup()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityGroup")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityGroup")
		public AbstractFacility getFacilityGroup() {
			return facilityGroup;
		}
		
		@Override
		public DealSequence build() {
			return this;
		}
		
		@Override
		public DealSequence.DealSequenceBuilder toBuilder() {
			DealSequence.DealSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DealSequence.DealSequenceBuilder builder) {
			ofNullable(getFacilityGroup()).ifPresent(builder::setFacilityGroup);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DealSequence _that = getType().cast(o);
		
			if (!Objects.equals(facilityGroup, _that.getFacilityGroup())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityGroup != null ? facilityGroup.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealSequence {" +
				"facilityGroup=" + this.facilityGroup +
			'}';
		}
	}

	/*********************** Builder Implementation of DealSequence  ***********************/
	class DealSequenceBuilderImpl implements DealSequence.DealSequenceBuilder {
	
		protected AbstractFacility.AbstractFacilityBuilder facilityGroup;
		
		@Override
		@RosettaAttribute("facilityGroup")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityGroup")
		public AbstractFacility.AbstractFacilityBuilder getFacilityGroup() {
			return facilityGroup;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder getOrCreateFacilityGroup() {
			AbstractFacility.AbstractFacilityBuilder result;
			if (facilityGroup!=null) {
				result = facilityGroup;
			}
			else {
				result = facilityGroup = AbstractFacility.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("facilityGroup")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityGroup")
		@Override
		public DealSequence.DealSequenceBuilder setFacilityGroup(AbstractFacility _facilityGroup) {
			this.facilityGroup = _facilityGroup == null ? null : _facilityGroup.toBuilder();
			return this;
		}
		
		@Override
		public DealSequence build() {
			return new DealSequence.DealSequenceImpl(this);
		}
		
		@Override
		public DealSequence.DealSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealSequence.DealSequenceBuilder prune() {
			if (facilityGroup!=null && !facilityGroup.prune().hasData()) facilityGroup = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFacilityGroup()!=null && getFacilityGroup().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealSequence.DealSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DealSequence.DealSequenceBuilder o = (DealSequence.DealSequenceBuilder) other;
			
			merger.mergeRosetta(getFacilityGroup(), o.getFacilityGroup(), this::setFacilityGroup);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DealSequence _that = getType().cast(o);
		
			if (!Objects.equals(facilityGroup, _that.getFacilityGroup())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityGroup != null ? facilityGroup.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealSequenceBuilder {" +
				"facilityGroup=" + this.facilityGroup +
			'}';
		}
	}
}
