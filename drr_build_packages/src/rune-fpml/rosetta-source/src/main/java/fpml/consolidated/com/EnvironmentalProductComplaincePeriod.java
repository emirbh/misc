package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.EnvironmentalProductComplaincePeriodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="EnvironmentalProductComplaincePeriod", builder=EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EnvironmentalProductComplaincePeriod", model="fpml", builder=EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilderImpl.class, version="2.1.1")
public interface EnvironmentalProductComplaincePeriod extends RosettaModelObject {

	EnvironmentalProductComplaincePeriodMeta metaData = new EnvironmentalProductComplaincePeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The first year of the Compliance Period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The first year of the Compliance Period.
	 *
	 */
	String getStartYear();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The last year of the Commpliance Period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The last year of the Commpliance Period.
	 *
	 */
	String getEndYear();

	/*********************** Build Methods  ***********************/
	EnvironmentalProductComplaincePeriod build();
	
	EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder toBuilder();
	
	static EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder builder() {
		return new EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnvironmentalProductComplaincePeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnvironmentalProductComplaincePeriod> getType() {
		return EnvironmentalProductComplaincePeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startYear"), String.class, getStartYear(), this);
		processor.processBasic(path.newSubPath("endYear"), String.class, getEndYear(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnvironmentalProductComplaincePeriodBuilder extends EnvironmentalProductComplaincePeriod, RosettaModelObjectBuilder {
		EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder setStartYear(String startYear);
		EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder setEndYear(String endYear);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startYear"), String.class, getStartYear(), this);
			processor.processBasic(path.newSubPath("endYear"), String.class, getEndYear(), this);
		}
		

		EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder prune();
	}

	/*********************** Immutable Implementation of EnvironmentalProductComplaincePeriod  ***********************/
	class EnvironmentalProductComplaincePeriodImpl implements EnvironmentalProductComplaincePeriod {
		private final String startYear;
		private final String endYear;
		
		protected EnvironmentalProductComplaincePeriodImpl(EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder builder) {
			this.startYear = builder.getStartYear();
			this.endYear = builder.getEndYear();
		}
		
		@Override
		@RosettaAttribute("startYear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startYear")
		public String getStartYear() {
			return startYear;
		}
		
		@Override
		@RosettaAttribute("endYear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endYear")
		public String getEndYear() {
			return endYear;
		}
		
		@Override
		public EnvironmentalProductComplaincePeriod build() {
			return this;
		}
		
		@Override
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder toBuilder() {
			EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder builder) {
			ofNullable(getStartYear()).ifPresent(builder::setStartYear);
			ofNullable(getEndYear()).ifPresent(builder::setEndYear);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalProductComplaincePeriod _that = getType().cast(o);
		
			if (!Objects.equals(startYear, _that.getStartYear())) return false;
			if (!Objects.equals(endYear, _that.getEndYear())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startYear != null ? startYear.hashCode() : 0);
			_result = 31 * _result + (endYear != null ? endYear.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalProductComplaincePeriod {" +
				"startYear=" + this.startYear + ", " +
				"endYear=" + this.endYear +
			'}';
		}
	}

	/*********************** Builder Implementation of EnvironmentalProductComplaincePeriod  ***********************/
	class EnvironmentalProductComplaincePeriodBuilderImpl implements EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder {
	
		protected String startYear;
		protected String endYear;
		
		@Override
		@RosettaAttribute("startYear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startYear")
		public String getStartYear() {
			return startYear;
		}
		
		@Override
		@RosettaAttribute("endYear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endYear")
		public String getEndYear() {
			return endYear;
		}
		
		@RosettaAttribute("startYear")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startYear")
		@Override
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder setStartYear(String _startYear) {
			this.startYear = _startYear == null ? null : _startYear;
			return this;
		}
		
		@RosettaAttribute("endYear")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endYear")
		@Override
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder setEndYear(String _endYear) {
			this.endYear = _endYear == null ? null : _endYear;
			return this;
		}
		
		@Override
		public EnvironmentalProductComplaincePeriod build() {
			return new EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodImpl(this);
		}
		
		@Override
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartYear()!=null) return true;
			if (getEndYear()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder o = (EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder) other;
			
			
			merger.mergeBasic(getStartYear(), o.getStartYear(), this::setStartYear);
			merger.mergeBasic(getEndYear(), o.getEndYear(), this::setEndYear);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalProductComplaincePeriod _that = getType().cast(o);
		
			if (!Objects.equals(startYear, _that.getStartYear())) return false;
			if (!Objects.equals(endYear, _that.getEndYear())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startYear != null ? startYear.hashCode() : 0);
			_result = 31 * _result + (endYear != null ? endYear.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalProductComplaincePeriodBuilder {" +
				"startYear=" + this.startYear + ", " +
				"endYear=" + this.endYear +
			'}';
		}
	}
}
