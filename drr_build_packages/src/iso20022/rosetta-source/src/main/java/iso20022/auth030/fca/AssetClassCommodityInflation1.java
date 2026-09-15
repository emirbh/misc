package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.AssetClassCommodityInflation1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is inflation.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityInflation1", builder=AssetClassCommodityInflation1.AssetClassCommodityInflation1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityInflation1", model="iso20022", builder=AssetClassCommodityInflation1.AssetClassCommodityInflation1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityInflation1 extends RosettaModelObject {

	AssetClassCommodityInflation1Meta metaData = new AssetClassCommodityInflation1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType12Code getBasePdct();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityInflation1 build();
	
	AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder toBuilder();
	
	static AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder builder() {
		return new AssetClassCommodityInflation1.AssetClassCommodityInflation1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityInflation1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityInflation1> getType() {
		return AssetClassCommodityInflation1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType12Code.class, getBasePdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityInflation1Builder extends AssetClassCommodityInflation1, RosettaModelObjectBuilder {
		AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder setBasePdct(AssetClassProductType12Code basePdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType12Code.class, getBasePdct(), this);
		}
		

		AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityInflation1  ***********************/
	class AssetClassCommodityInflation1Impl implements AssetClassCommodityInflation1 {
		private final AssetClassProductType12Code basePdct;
		
		protected AssetClassCommodityInflation1Impl(AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder builder) {
			this.basePdct = builder.getBasePdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType12Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		public AssetClassCommodityInflation1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder toBuilder() {
			AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityInflation1 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityInflation1 {" +
				"basePdct=" + this.basePdct +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityInflation1  ***********************/
	class AssetClassCommodityInflation1BuilderImpl implements AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder {
	
		protected AssetClassProductType12Code basePdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType12Code getBasePdct() {
			return basePdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder setBasePdct(AssetClassProductType12Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@Override
		public AssetClassCommodityInflation1 build() {
			return new AssetClassCommodityInflation1.AssetClassCommodityInflation1Impl(this);
		}
		
		@Override
		public AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasePdct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder o = (AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityInflation1 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityInflation1Builder {" +
				"basePdct=" + this.basePdct +
			'}';
		}
	}
}
