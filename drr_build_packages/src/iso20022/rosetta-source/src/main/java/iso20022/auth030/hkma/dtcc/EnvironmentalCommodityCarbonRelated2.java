package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.EnvironmentalCommodityCarbonRelated2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an environmental derivative of type carbon related.
 * @version ${project.version}
 */
@RosettaDataType(value="EnvironmentalCommodityCarbonRelated2", builder=EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EnvironmentalCommodityCarbonRelated2", model="iso20022", builder=EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2BuilderImpl.class, version="${project.version}")
public interface EnvironmentalCommodityCarbonRelated2 extends RosettaModelObject {

	EnvironmentalCommodityCarbonRelated2Meta metaData = new EnvironmentalCommodityCarbonRelated2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType3Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType29Code getSubPdct();

	/*********************** Build Methods  ***********************/
	EnvironmentalCommodityCarbonRelated2 build();
	
	EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder toBuilder();
	
	static EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder builder() {
		return new EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnvironmentalCommodityCarbonRelated2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnvironmentalCommodityCarbonRelated2> getType() {
		return EnvironmentalCommodityCarbonRelated2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType3Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType29Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnvironmentalCommodityCarbonRelated2Builder extends EnvironmentalCommodityCarbonRelated2, RosettaModelObjectBuilder {
		EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder setBasePdct(AssetClassProductType3Code basePdct);
		EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder setSubPdct(AssetClassSubProductType29Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType3Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType29Code.class, getSubPdct(), this);
		}
		

		EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder prune();
	}

	/*********************** Immutable Implementation of EnvironmentalCommodityCarbonRelated2  ***********************/
	class EnvironmentalCommodityCarbonRelated2Impl implements EnvironmentalCommodityCarbonRelated2 {
		private final AssetClassProductType3Code basePdct;
		private final AssetClassSubProductType29Code subPdct;
		
		protected EnvironmentalCommodityCarbonRelated2Impl(EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType3Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType29Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public EnvironmentalCommodityCarbonRelated2 build() {
			return this;
		}
		
		@Override
		public EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder toBuilder() {
			EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalCommodityCarbonRelated2 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalCommodityCarbonRelated2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of EnvironmentalCommodityCarbonRelated2  ***********************/
	class EnvironmentalCommodityCarbonRelated2BuilderImpl implements EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder {
	
		protected AssetClassProductType3Code basePdct;
		protected AssetClassSubProductType29Code subPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType3Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType29Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder setBasePdct(AssetClassProductType3Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder setSubPdct(AssetClassSubProductType29Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public EnvironmentalCommodityCarbonRelated2 build() {
			return new EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Impl(this);
		}
		
		@Override
		public EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasePdct()!=null) return true;
			if (getSubPdct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder o = (EnvironmentalCommodityCarbonRelated2.EnvironmentalCommodityCarbonRelated2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalCommodityCarbonRelated2 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalCommodityCarbonRelated2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
