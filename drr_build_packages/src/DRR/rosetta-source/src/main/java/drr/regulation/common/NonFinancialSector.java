package drr.regulation.common;

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
import drr.regulation.common.meta.NonFinancialSectorMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the ESMA Non Financial Sector of a counterparty and the ordinality of the relative importance of the corresponding activity.
 * @version 7.7.0
 */
@RosettaDataType(value="NonFinancialSector", builder=NonFinancialSector.NonFinancialSectorBuilderImpl.class, version="7.7.0")
@RuneDataType(value="NonFinancialSector", model="drr", builder=NonFinancialSector.NonFinancialSectorBuilderImpl.class, version="7.7.0")
public interface NonFinancialSector extends RosettaModelObject {

	NonFinancialSectorMeta metaData = new NonFinancialSectorMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the order of relative importance of each activity
	 */
	Integer getOrdinal();
	/**
	 * Specifies the ESMA EMIR Non Financial Sector of a counterparty
	 */
	NonFinancialSectorEnum getNonFinancialSectorIndicator();

	/*********************** Build Methods  ***********************/
	NonFinancialSector build();
	
	NonFinancialSector.NonFinancialSectorBuilder toBuilder();
	
	static NonFinancialSector.NonFinancialSectorBuilder builder() {
		return new NonFinancialSector.NonFinancialSectorBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonFinancialSector> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonFinancialSector> getType() {
		return NonFinancialSector.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ordinal"), Integer.class, getOrdinal(), this);
		processor.processBasic(path.newSubPath("nonFinancialSectorIndicator"), NonFinancialSectorEnum.class, getNonFinancialSectorIndicator(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonFinancialSectorBuilder extends NonFinancialSector, RosettaModelObjectBuilder {
		NonFinancialSector.NonFinancialSectorBuilder setOrdinal(Integer ordinal);
		NonFinancialSector.NonFinancialSectorBuilder setNonFinancialSectorIndicator(NonFinancialSectorEnum nonFinancialSectorIndicator);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ordinal"), Integer.class, getOrdinal(), this);
			processor.processBasic(path.newSubPath("nonFinancialSectorIndicator"), NonFinancialSectorEnum.class, getNonFinancialSectorIndicator(), this);
		}
		

		NonFinancialSector.NonFinancialSectorBuilder prune();
	}

	/*********************** Immutable Implementation of NonFinancialSector  ***********************/
	class NonFinancialSectorImpl implements NonFinancialSector {
		private final Integer ordinal;
		private final NonFinancialSectorEnum nonFinancialSectorIndicator;
		
		protected NonFinancialSectorImpl(NonFinancialSector.NonFinancialSectorBuilder builder) {
			this.ordinal = builder.getOrdinal();
			this.nonFinancialSectorIndicator = builder.getNonFinancialSectorIndicator();
		}
		
		@Override
		@RosettaAttribute("ordinal")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ordinal")
		public Integer getOrdinal() {
			return ordinal;
		}
		
		@Override
		@RosettaAttribute("nonFinancialSectorIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nonFinancialSectorIndicator")
		public NonFinancialSectorEnum getNonFinancialSectorIndicator() {
			return nonFinancialSectorIndicator;
		}
		
		@Override
		public NonFinancialSector build() {
			return this;
		}
		
		@Override
		public NonFinancialSector.NonFinancialSectorBuilder toBuilder() {
			NonFinancialSector.NonFinancialSectorBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonFinancialSector.NonFinancialSectorBuilder builder) {
			ofNullable(getOrdinal()).ifPresent(builder::setOrdinal);
			ofNullable(getNonFinancialSectorIndicator()).ifPresent(builder::setNonFinancialSectorIndicator);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonFinancialSector _that = getType().cast(o);
		
			if (!Objects.equals(ordinal, _that.getOrdinal())) return false;
			if (!Objects.equals(nonFinancialSectorIndicator, _that.getNonFinancialSectorIndicator())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ordinal != null ? ordinal.hashCode() : 0);
			_result = 31 * _result + (nonFinancialSectorIndicator != null ? nonFinancialSectorIndicator.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonFinancialSector {" +
				"ordinal=" + this.ordinal + ", " +
				"nonFinancialSectorIndicator=" + this.nonFinancialSectorIndicator +
			'}';
		}
	}

	/*********************** Builder Implementation of NonFinancialSector  ***********************/
	class NonFinancialSectorBuilderImpl implements NonFinancialSector.NonFinancialSectorBuilder {
	
		protected Integer ordinal;
		protected NonFinancialSectorEnum nonFinancialSectorIndicator;
		
		@Override
		@RosettaAttribute("ordinal")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ordinal")
		public Integer getOrdinal() {
			return ordinal;
		}
		
		@Override
		@RosettaAttribute("nonFinancialSectorIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nonFinancialSectorIndicator")
		public NonFinancialSectorEnum getNonFinancialSectorIndicator() {
			return nonFinancialSectorIndicator;
		}
		
		@RosettaAttribute("ordinal")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ordinal")
		@Override
		public NonFinancialSector.NonFinancialSectorBuilder setOrdinal(Integer _ordinal) {
			this.ordinal = _ordinal == null ? null : _ordinal;
			return this;
		}
		
		@RosettaAttribute("nonFinancialSectorIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nonFinancialSectorIndicator")
		@Override
		public NonFinancialSector.NonFinancialSectorBuilder setNonFinancialSectorIndicator(NonFinancialSectorEnum _nonFinancialSectorIndicator) {
			this.nonFinancialSectorIndicator = _nonFinancialSectorIndicator == null ? null : _nonFinancialSectorIndicator;
			return this;
		}
		
		@Override
		public NonFinancialSector build() {
			return new NonFinancialSector.NonFinancialSectorImpl(this);
		}
		
		@Override
		public NonFinancialSector.NonFinancialSectorBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonFinancialSector.NonFinancialSectorBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOrdinal()!=null) return true;
			if (getNonFinancialSectorIndicator()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonFinancialSector.NonFinancialSectorBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonFinancialSector.NonFinancialSectorBuilder o = (NonFinancialSector.NonFinancialSectorBuilder) other;
			
			
			merger.mergeBasic(getOrdinal(), o.getOrdinal(), this::setOrdinal);
			merger.mergeBasic(getNonFinancialSectorIndicator(), o.getNonFinancialSectorIndicator(), this::setNonFinancialSectorIndicator);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonFinancialSector _that = getType().cast(o);
		
			if (!Objects.equals(ordinal, _that.getOrdinal())) return false;
			if (!Objects.equals(nonFinancialSectorIndicator, _that.getNonFinancialSectorIndicator())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ordinal != null ? ordinal.hashCode() : 0);
			_result = 31 * _result + (nonFinancialSectorIndicator != null ? nonFinancialSectorIndicator.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonFinancialSectorBuilder {" +
				"ordinal=" + this.ordinal + ", " +
				"nonFinancialSectorIndicator=" + this.nonFinancialSectorIndicator +
			'}';
		}
	}
}
