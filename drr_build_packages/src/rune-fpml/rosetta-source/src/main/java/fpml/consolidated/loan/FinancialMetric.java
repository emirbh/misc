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
import fpml.consolidated.loan.meta.FinancialMetricMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure to describe a financial statement of balance sheet metric.
 *
 */
@RosettaDataType(value="FinancialMetric", builder=FinancialMetric.FinancialMetricBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FinancialMetric", model="fpml", builder=FinancialMetric.FinancialMetricBuilderImpl.class, version="2.1.1")
public interface FinancialMetric extends RosettaModelObject {

	FinancialMetricMeta metaData = new FinancialMetricMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A financial metric value type, based on a scheme.
	 *
	 */
	FinancialMetricType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional free form text field to further describe the financial metric.
	 *
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	FinancialMetric build();
	
	FinancialMetric.FinancialMetricBuilder toBuilder();
	
	static FinancialMetric.FinancialMetricBuilder builder() {
		return new FinancialMetric.FinancialMetricBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FinancialMetric> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FinancialMetric> getType() {
		return FinancialMetric.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("type"), processor, FinancialMetricType.class, _getType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FinancialMetricBuilder extends FinancialMetric, RosettaModelObjectBuilder {
		FinancialMetricType.FinancialMetricTypeBuilder getOrCreateType();
		@Override
		FinancialMetricType.FinancialMetricTypeBuilder _getType();
		FinancialMetric.FinancialMetricBuilder setType(FinancialMetricType type);
		FinancialMetric.FinancialMetricBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("type"), processor, FinancialMetricType.FinancialMetricTypeBuilder.class, _getType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		FinancialMetric.FinancialMetricBuilder prune();
	}

	/*********************** Immutable Implementation of FinancialMetric  ***********************/
	class FinancialMetricImpl implements FinancialMetric {
		private final FinancialMetricType type;
		private final String description;
		
		protected FinancialMetricImpl(FinancialMetric.FinancialMetricBuilder builder) {
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.description = builder.getDescription();
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public FinancialMetricType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		public FinancialMetric build() {
			return this;
		}
		
		@Override
		public FinancialMetric.FinancialMetricBuilder toBuilder() {
			FinancialMetric.FinancialMetricBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FinancialMetric.FinancialMetricBuilder builder) {
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinancialMetric _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialMetric {" +
				"type=" + this.type + ", " +
				"description=" + this.description +
			'}';
		}
	}

	/*********************** Builder Implementation of FinancialMetric  ***********************/
	class FinancialMetricBuilderImpl implements FinancialMetric.FinancialMetricBuilder {
	
		protected FinancialMetricType.FinancialMetricTypeBuilder type;
		protected String description;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public FinancialMetricType.FinancialMetricTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public FinancialMetricType.FinancialMetricTypeBuilder getOrCreateType() {
			FinancialMetricType.FinancialMetricTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = FinancialMetricType.builder();
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
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public FinancialMetric.FinancialMetricBuilder setType(FinancialMetricType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public FinancialMetric.FinancialMetricBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public FinancialMetric build() {
			return new FinancialMetric.FinancialMetricImpl(this);
		}
		
		@Override
		public FinancialMetric.FinancialMetricBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialMetric.FinancialMetricBuilder prune() {
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (_getType()!=null && _getType().hasData()) return true;
			if (getDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialMetric.FinancialMetricBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FinancialMetric.FinancialMetricBuilder o = (FinancialMetric.FinancialMetricBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinancialMetric _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialMetricBuilder {" +
				"type=" + this.type + ", " +
				"description=" + this.description +
			'}';
		}
	}
}
