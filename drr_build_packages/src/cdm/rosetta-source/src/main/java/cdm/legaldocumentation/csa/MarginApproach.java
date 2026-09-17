package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.MarginApproachMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class for selection of Margin Approach.
 * @version 6.23.0
 */
@RosettaDataType(value="MarginApproach", builder=MarginApproach.MarginApproachBuilderImpl.class, version="6.23.0")
@RuneDataType(value="MarginApproach", model="cdm", builder=MarginApproach.MarginApproachBuilderImpl.class, version="6.23.0")
public interface MarginApproach extends RosettaModelObject {

	MarginApproachMeta metaData = new MarginApproachMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the margin approach specific to Initial Margin agreements.
	 */
	MarginApproachEnum getMarginApproach();

	/*********************** Build Methods  ***********************/
	MarginApproach build();
	
	MarginApproach.MarginApproachBuilder toBuilder();
	
	static MarginApproach.MarginApproachBuilder builder() {
		return new MarginApproach.MarginApproachBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarginApproach> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarginApproach> getType() {
		return MarginApproach.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("marginApproach"), MarginApproachEnum.class, getMarginApproach(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarginApproachBuilder extends MarginApproach, RosettaModelObjectBuilder {
		MarginApproach.MarginApproachBuilder setMarginApproach(MarginApproachEnum marginApproach);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("marginApproach"), MarginApproachEnum.class, getMarginApproach(), this);
		}
		

		MarginApproach.MarginApproachBuilder prune();
	}

	/*********************** Immutable Implementation of MarginApproach  ***********************/
	class MarginApproachImpl implements MarginApproach {
		private final MarginApproachEnum marginApproach;
		
		protected MarginApproachImpl(MarginApproach.MarginApproachBuilder builder) {
			this.marginApproach = builder.getMarginApproach();
		}
		
		@Override
		@RosettaAttribute("marginApproach")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("marginApproach")
		public MarginApproachEnum getMarginApproach() {
			return marginApproach;
		}
		
		@Override
		public MarginApproach build() {
			return this;
		}
		
		@Override
		public MarginApproach.MarginApproachBuilder toBuilder() {
			MarginApproach.MarginApproachBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarginApproach.MarginApproachBuilder builder) {
			ofNullable(getMarginApproach()).ifPresent(builder::setMarginApproach);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginApproach _that = getType().cast(o);
		
			if (!Objects.equals(marginApproach, _that.getMarginApproach())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marginApproach != null ? marginApproach.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginApproach {" +
				"marginApproach=" + this.marginApproach +
			'}';
		}
	}

	/*********************** Builder Implementation of MarginApproach  ***********************/
	class MarginApproachBuilderImpl implements MarginApproach.MarginApproachBuilder {
	
		protected MarginApproachEnum marginApproach;
		
		@Override
		@RosettaAttribute("marginApproach")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("marginApproach")
		public MarginApproachEnum getMarginApproach() {
			return marginApproach;
		}
		
		@RosettaAttribute("marginApproach")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("marginApproach")
		@Override
		public MarginApproach.MarginApproachBuilder setMarginApproach(MarginApproachEnum _marginApproach) {
			this.marginApproach = _marginApproach == null ? null : _marginApproach;
			return this;
		}
		
		@Override
		public MarginApproach build() {
			return new MarginApproach.MarginApproachImpl(this);
		}
		
		@Override
		public MarginApproach.MarginApproachBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginApproach.MarginApproachBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMarginApproach()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginApproach.MarginApproachBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MarginApproach.MarginApproachBuilder o = (MarginApproach.MarginApproachBuilder) other;
			
			
			merger.mergeBasic(getMarginApproach(), o.getMarginApproach(), this::setMarginApproach);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginApproach _that = getType().cast(o);
		
			if (!Objects.equals(marginApproach, _that.getMarginApproach())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marginApproach != null ? marginApproach.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginApproachBuilder {" +
				"marginApproach=" + this.marginApproach +
			'}';
		}
	}
}
