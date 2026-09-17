package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.CommodityInformationProviderMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The publication in which the rate, price, index or factor is to be found. (e.g Gas Daily, Platts Bloomberg.)
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The publication in which the rate, price, index or factor is to be found. (e.g Gas Daily, Platts Bloomberg.)
 *
 */
@RosettaDataType(value="CommodityInformationProvider", builder=CommodityInformationProvider.CommodityInformationProviderBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityInformationProvider", model="fpml", builder=CommodityInformationProvider.CommodityInformationProviderBuilderImpl.class, version="2.1.1")
public interface CommodityInformationProvider extends RosettaModelObject {

	CommodityInformationProviderMeta metaData = new CommodityInformationProviderMeta();

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
	String getValue();
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
	String getInformationProviderScheme();

	/*********************** Build Methods  ***********************/
	CommodityInformationProvider build();
	
	CommodityInformationProvider.CommodityInformationProviderBuilder toBuilder();
	
	static CommodityInformationProvider.CommodityInformationProviderBuilder builder() {
		return new CommodityInformationProvider.CommodityInformationProviderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityInformationProvider> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityInformationProvider> getType() {
		return CommodityInformationProvider.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("informationProviderScheme"), String.class, getInformationProviderScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityInformationProviderBuilder extends CommodityInformationProvider, RosettaModelObjectBuilder {
		CommodityInformationProvider.CommodityInformationProviderBuilder setValue(String value);
		CommodityInformationProvider.CommodityInformationProviderBuilder setInformationProviderScheme(String informationProviderScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("informationProviderScheme"), String.class, getInformationProviderScheme(), this);
		}
		

		CommodityInformationProvider.CommodityInformationProviderBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityInformationProvider  ***********************/
	class CommodityInformationProviderImpl implements CommodityInformationProvider {
		private final String value;
		private final String informationProviderScheme;
		
		protected CommodityInformationProviderImpl(CommodityInformationProvider.CommodityInformationProviderBuilder builder) {
			this.value = builder.getValue();
			this.informationProviderScheme = builder.getInformationProviderScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("informationProviderScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("informationProviderScheme")
		public String getInformationProviderScheme() {
			return informationProviderScheme;
		}
		
		@Override
		public CommodityInformationProvider build() {
			return this;
		}
		
		@Override
		public CommodityInformationProvider.CommodityInformationProviderBuilder toBuilder() {
			CommodityInformationProvider.CommodityInformationProviderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityInformationProvider.CommodityInformationProviderBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getInformationProviderScheme()).ifPresent(builder::setInformationProviderScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityInformationProvider _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(informationProviderScheme, _that.getInformationProviderScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (informationProviderScheme != null ? informationProviderScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityInformationProvider {" +
				"value=" + this.value + ", " +
				"informationProviderScheme=" + this.informationProviderScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityInformationProvider  ***********************/
	class CommodityInformationProviderBuilderImpl implements CommodityInformationProvider.CommodityInformationProviderBuilder {
	
		protected String value;
		protected String informationProviderScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("informationProviderScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("informationProviderScheme")
		public String getInformationProviderScheme() {
			return informationProviderScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CommodityInformationProvider.CommodityInformationProviderBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("informationProviderScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("informationProviderScheme")
		@Override
		public CommodityInformationProvider.CommodityInformationProviderBuilder setInformationProviderScheme(String _informationProviderScheme) {
			this.informationProviderScheme = _informationProviderScheme == null ? null : _informationProviderScheme;
			return this;
		}
		
		@Override
		public CommodityInformationProvider build() {
			return new CommodityInformationProvider.CommodityInformationProviderImpl(this);
		}
		
		@Override
		public CommodityInformationProvider.CommodityInformationProviderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityInformationProvider.CommodityInformationProviderBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getInformationProviderScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityInformationProvider.CommodityInformationProviderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityInformationProvider.CommodityInformationProviderBuilder o = (CommodityInformationProvider.CommodityInformationProviderBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getInformationProviderScheme(), o.getInformationProviderScheme(), this::setInformationProviderScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityInformationProvider _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(informationProviderScheme, _that.getInformationProviderScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (informationProviderScheme != null ? informationProviderScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityInformationProviderBuilder {" +
				"value=" + this.value + ", " +
				"informationProviderScheme=" + this.informationProviderScheme +
			'}';
		}
	}
}
