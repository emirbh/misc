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
import fpml.consolidated.shared.meta.ObservationOffsetMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that allows an offset specified in business days to be applied for an observation shift, lookback, or lockout provision.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that allows an offset specified in business days to be applied for an observation shift, lookback, or lockout provision.
 *
 */
@RosettaDataType(value="ObservationOffset", builder=ObservationOffset.ObservationOffsetBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ObservationOffset", model="fpml", builder=ObservationOffset.ObservationOffsetBuilderImpl.class, version="2.1.1")
public interface ObservationOffset extends RosettaModelObject {

	ObservationOffsetMeta metaData = new ObservationOffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of business days before the base date that the observations are to be shifted. If this element is omitted, the number of offset days will be as specified in the 2021 ISDA Definitions, which is typically 5.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of business days before the base date that the observations are to be shifted. If this element is omitted, the number of offset days will be as specified in the 2021 ISDA Definitions, which is typically 5.
	 *
	 */
	Integer getOffsetDays();

	/*********************** Build Methods  ***********************/
	ObservationOffset build();
	
	ObservationOffset.ObservationOffsetBuilder toBuilder();
	
	static ObservationOffset.ObservationOffsetBuilder builder() {
		return new ObservationOffset.ObservationOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservationOffset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObservationOffset> getType() {
		return ObservationOffset.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("offsetDays"), Integer.class, getOffsetDays(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservationOffsetBuilder extends ObservationOffset, RosettaModelObjectBuilder {
		ObservationOffset.ObservationOffsetBuilder setOffsetDays(Integer offsetDays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("offsetDays"), Integer.class, getOffsetDays(), this);
		}
		

		ObservationOffset.ObservationOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of ObservationOffset  ***********************/
	class ObservationOffsetImpl implements ObservationOffset {
		private final Integer offsetDays;
		
		protected ObservationOffsetImpl(ObservationOffset.ObservationOffsetBuilder builder) {
			this.offsetDays = builder.getOffsetDays();
		}
		
		@Override
		@RosettaAttribute("offsetDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("offsetDays")
		public Integer getOffsetDays() {
			return offsetDays;
		}
		
		@Override
		public ObservationOffset build() {
			return this;
		}
		
		@Override
		public ObservationOffset.ObservationOffsetBuilder toBuilder() {
			ObservationOffset.ObservationOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationOffset.ObservationOffsetBuilder builder) {
			ofNullable(getOffsetDays()).ifPresent(builder::setOffsetDays);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationOffset _that = getType().cast(o);
		
			if (!Objects.equals(offsetDays, _that.getOffsetDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (offsetDays != null ? offsetDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationOffset {" +
				"offsetDays=" + this.offsetDays +
			'}';
		}
	}

	/*********************** Builder Implementation of ObservationOffset  ***********************/
	class ObservationOffsetBuilderImpl implements ObservationOffset.ObservationOffsetBuilder {
	
		protected Integer offsetDays;
		
		@Override
		@RosettaAttribute("offsetDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("offsetDays")
		public Integer getOffsetDays() {
			return offsetDays;
		}
		
		@RosettaAttribute("offsetDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("offsetDays")
		@Override
		public ObservationOffset.ObservationOffsetBuilder setOffsetDays(Integer _offsetDays) {
			this.offsetDays = _offsetDays == null ? null : _offsetDays;
			return this;
		}
		
		@Override
		public ObservationOffset build() {
			return new ObservationOffset.ObservationOffsetImpl(this);
		}
		
		@Override
		public ObservationOffset.ObservationOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationOffset.ObservationOffsetBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOffsetDays()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationOffset.ObservationOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservationOffset.ObservationOffsetBuilder o = (ObservationOffset.ObservationOffsetBuilder) other;
			
			
			merger.mergeBasic(getOffsetDays(), o.getOffsetDays(), this::setOffsetDays);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationOffset _that = getType().cast(o);
		
			if (!Objects.equals(offsetDays, _that.getOffsetDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (offsetDays != null ? offsetDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationOffsetBuilder {" +
				"offsetDays=" + this.offsetDays +
			'}';
		}
	}
}
