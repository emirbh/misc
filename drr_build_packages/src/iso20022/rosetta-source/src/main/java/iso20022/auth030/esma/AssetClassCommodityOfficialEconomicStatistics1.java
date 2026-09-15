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
import iso20022.auth030.esma.meta.AssetClassCommodityOfficialEconomicStatistics1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is official economic statistics.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityOfficialEconomicStatistics1", builder=AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityOfficialEconomicStatistics1", model="iso20022", builder=AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityOfficialEconomicStatistics1 extends RosettaModelObject {

	AssetClassCommodityOfficialEconomicStatistics1Meta metaData = new AssetClassCommodityOfficialEconomicStatistics1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType14Code getBasePdct();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityOfficialEconomicStatistics1 build();
	
	AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder toBuilder();
	
	static AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder builder() {
		return new AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityOfficialEconomicStatistics1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityOfficialEconomicStatistics1> getType() {
		return AssetClassCommodityOfficialEconomicStatistics1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType14Code.class, getBasePdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityOfficialEconomicStatistics1Builder extends AssetClassCommodityOfficialEconomicStatistics1, RosettaModelObjectBuilder {
		AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder setBasePdct(AssetClassProductType14Code basePdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType14Code.class, getBasePdct(), this);
		}
		

		AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityOfficialEconomicStatistics1  ***********************/
	class AssetClassCommodityOfficialEconomicStatistics1Impl implements AssetClassCommodityOfficialEconomicStatistics1 {
		private final AssetClassProductType14Code basePdct;
		
		protected AssetClassCommodityOfficialEconomicStatistics1Impl(AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder builder) {
			this.basePdct = builder.getBasePdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType14Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		public AssetClassCommodityOfficialEconomicStatistics1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder toBuilder() {
			AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityOfficialEconomicStatistics1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityOfficialEconomicStatistics1 {" +
				"basePdct=" + this.basePdct +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityOfficialEconomicStatistics1  ***********************/
	class AssetClassCommodityOfficialEconomicStatistics1BuilderImpl implements AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder {
	
		protected AssetClassProductType14Code basePdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType14Code getBasePdct() {
			return basePdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder setBasePdct(AssetClassProductType14Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@Override
		public AssetClassCommodityOfficialEconomicStatistics1 build() {
			return new AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Impl(this);
		}
		
		@Override
		public AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasePdct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder o = (AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityOfficialEconomicStatistics1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityOfficialEconomicStatistics1Builder {" +
				"basePdct=" + this.basePdct +
			'}';
		}
	}
}
