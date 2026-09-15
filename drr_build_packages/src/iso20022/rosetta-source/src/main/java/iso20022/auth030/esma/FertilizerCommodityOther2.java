package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.FertilizerCommodityOther2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Other fertlizer commodity derivative.
 * @version ${project.version}
 */
@RosettaDataType(value="FertilizerCommodityOther2", builder=FertilizerCommodityOther2.FertilizerCommodityOther2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FertilizerCommodityOther2", model="iso20022", builder=FertilizerCommodityOther2.FertilizerCommodityOther2BuilderImpl.class, version="${project.version}")
public interface FertilizerCommodityOther2 extends RosettaModelObject {

	FertilizerCommodityOther2Meta metaData = new FertilizerCommodityOther2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType5Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType49Code getSubPdct();

	/*********************** Build Methods  ***********************/
	FertilizerCommodityOther2 build();
	
	FertilizerCommodityOther2.FertilizerCommodityOther2Builder toBuilder();
	
	static FertilizerCommodityOther2.FertilizerCommodityOther2Builder builder() {
		return new FertilizerCommodityOther2.FertilizerCommodityOther2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FertilizerCommodityOther2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FertilizerCommodityOther2> getType() {
		return FertilizerCommodityOther2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType5Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType49Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FertilizerCommodityOther2Builder extends FertilizerCommodityOther2, RosettaModelObjectBuilder {
		FertilizerCommodityOther2.FertilizerCommodityOther2Builder setBasePdct(AssetClassProductType5Code basePdct);
		FertilizerCommodityOther2.FertilizerCommodityOther2Builder setSubPdct(AssetClassSubProductType49Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType5Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType49Code.class, getSubPdct(), this);
		}
		

		FertilizerCommodityOther2.FertilizerCommodityOther2Builder prune();
	}

	/*********************** Immutable Implementation of FertilizerCommodityOther2  ***********************/
	class FertilizerCommodityOther2Impl implements FertilizerCommodityOther2 {
		private final AssetClassProductType5Code basePdct;
		private final AssetClassSubProductType49Code subPdct;
		
		protected FertilizerCommodityOther2Impl(FertilizerCommodityOther2.FertilizerCommodityOther2Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType5Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType49Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public FertilizerCommodityOther2 build() {
			return this;
		}
		
		@Override
		public FertilizerCommodityOther2.FertilizerCommodityOther2Builder toBuilder() {
			FertilizerCommodityOther2.FertilizerCommodityOther2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FertilizerCommodityOther2.FertilizerCommodityOther2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FertilizerCommodityOther2 _that = getType().cast(o);
		
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
			return "FertilizerCommodityOther2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of FertilizerCommodityOther2  ***********************/
	class FertilizerCommodityOther2BuilderImpl implements FertilizerCommodityOther2.FertilizerCommodityOther2Builder {
	
		protected AssetClassProductType5Code basePdct;
		protected AssetClassSubProductType49Code subPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType5Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType49Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public FertilizerCommodityOther2.FertilizerCommodityOther2Builder setBasePdct(AssetClassProductType5Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public FertilizerCommodityOther2.FertilizerCommodityOther2Builder setSubPdct(AssetClassSubProductType49Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public FertilizerCommodityOther2 build() {
			return new FertilizerCommodityOther2.FertilizerCommodityOther2Impl(this);
		}
		
		@Override
		public FertilizerCommodityOther2.FertilizerCommodityOther2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FertilizerCommodityOther2.FertilizerCommodityOther2Builder prune() {
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
		public FertilizerCommodityOther2.FertilizerCommodityOther2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FertilizerCommodityOther2.FertilizerCommodityOther2Builder o = (FertilizerCommodityOther2.FertilizerCommodityOther2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FertilizerCommodityOther2 _that = getType().cast(o);
		
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
			return "FertilizerCommodityOther2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
