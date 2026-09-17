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
import fpml.consolidated.shared.meta.ScheduledDateBaseMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision An servicing date relevant for a trade structure, such as a payment or a reset.
 *
 */
@RosettaDataType(value="ScheduledDateBase", builder=ScheduledDateBase.ScheduledDateBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ScheduledDateBase", model="fpml", builder=ScheduledDateBase.ScheduledDateBaseBuilderImpl.class, version="2.1.1")
public interface ScheduledDateBase extends RosettaModelObject {

	ScheduledDateBaseMeta metaData = new ScheduledDateBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	ZonedDateTime getUnadjustedDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	ZonedDateTime getAdjustedDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of the date, e.g. next or previous payment.
	 *
	 */
	ScheduledDateType _getType();

	/*********************** Build Methods  ***********************/
	ScheduledDateBase build();
	
	ScheduledDateBase.ScheduledDateBaseBuilder toBuilder();
	
	static ScheduledDateBase.ScheduledDateBaseBuilder builder() {
		return new ScheduledDateBase.ScheduledDateBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ScheduledDateBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ScheduledDateBase> getType() {
		return ScheduledDateBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unadjustedDate"), ZonedDateTime.class, getUnadjustedDate(), this);
		processor.processBasic(path.newSubPath("adjustedDate"), ZonedDateTime.class, getAdjustedDate(), this);
		processRosetta(path.newSubPath("type"), processor, ScheduledDateType.class, _getType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ScheduledDateBaseBuilder extends ScheduledDateBase, RosettaModelObjectBuilder {
		ScheduledDateType.ScheduledDateTypeBuilder getOrCreateType();
		@Override
		ScheduledDateType.ScheduledDateTypeBuilder _getType();
		ScheduledDateBase.ScheduledDateBaseBuilder setUnadjustedDate(ZonedDateTime unadjustedDate);
		ScheduledDateBase.ScheduledDateBaseBuilder setAdjustedDate(ZonedDateTime adjustedDate);
		ScheduledDateBase.ScheduledDateBaseBuilder setType(ScheduledDateType type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unadjustedDate"), ZonedDateTime.class, getUnadjustedDate(), this);
			processor.processBasic(path.newSubPath("adjustedDate"), ZonedDateTime.class, getAdjustedDate(), this);
			processRosetta(path.newSubPath("type"), processor, ScheduledDateType.ScheduledDateTypeBuilder.class, _getType());
		}
		

		ScheduledDateBase.ScheduledDateBaseBuilder prune();
	}

	/*********************** Immutable Implementation of ScheduledDateBase  ***********************/
	class ScheduledDateBaseImpl implements ScheduledDateBase {
		private final ZonedDateTime unadjustedDate;
		private final ZonedDateTime adjustedDate;
		private final ScheduledDateType type;
		
		protected ScheduledDateBaseImpl(ScheduledDateBase.ScheduledDateBaseBuilder builder) {
			this.unadjustedDate = builder.getUnadjustedDate();
			this.adjustedDate = builder.getAdjustedDate();
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("unadjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedDate")
		public ZonedDateTime getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedDate")
		public ZonedDateTime getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public ScheduledDateType _getType() {
			return type;
		}
		
		@Override
		public ScheduledDateBase build() {
			return this;
		}
		
		@Override
		public ScheduledDateBase.ScheduledDateBaseBuilder toBuilder() {
			ScheduledDateBase.ScheduledDateBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ScheduledDateBase.ScheduledDateBaseBuilder builder) {
			ofNullable(getUnadjustedDate()).ifPresent(builder::setUnadjustedDate);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
			ofNullable(_getType()).ifPresent(builder::setType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ScheduledDateBase _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ScheduledDateBase {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"type=" + this.type +
			'}';
		}
	}

	/*********************** Builder Implementation of ScheduledDateBase  ***********************/
	class ScheduledDateBaseBuilderImpl implements ScheduledDateBase.ScheduledDateBaseBuilder {
	
		protected ZonedDateTime unadjustedDate;
		protected ZonedDateTime adjustedDate;
		protected ScheduledDateType.ScheduledDateTypeBuilder type;
		
		@Override
		@RosettaAttribute("unadjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedDate")
		public ZonedDateTime getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedDate")
		public ZonedDateTime getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public ScheduledDateType.ScheduledDateTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public ScheduledDateType.ScheduledDateTypeBuilder getOrCreateType() {
			ScheduledDateType.ScheduledDateTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = ScheduledDateType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("unadjustedDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedDate")
		@Override
		public ScheduledDateBase.ScheduledDateBaseBuilder setUnadjustedDate(ZonedDateTime _unadjustedDate) {
			this.unadjustedDate = _unadjustedDate == null ? null : _unadjustedDate;
			return this;
		}
		
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedDate")
		@Override
		public ScheduledDateBase.ScheduledDateBaseBuilder setAdjustedDate(ZonedDateTime _adjustedDate) {
			this.adjustedDate = _adjustedDate == null ? null : _adjustedDate;
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public ScheduledDateBase.ScheduledDateBaseBuilder setType(ScheduledDateType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@Override
		public ScheduledDateBase build() {
			return new ScheduledDateBase.ScheduledDateBaseImpl(this);
		}
		
		@Override
		public ScheduledDateBase.ScheduledDateBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ScheduledDateBase.ScheduledDateBaseBuilder prune() {
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnadjustedDate()!=null) return true;
			if (getAdjustedDate()!=null) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ScheduledDateBase.ScheduledDateBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ScheduledDateBase.ScheduledDateBaseBuilder o = (ScheduledDateBase.ScheduledDateBaseBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			merger.mergeBasic(getUnadjustedDate(), o.getUnadjustedDate(), this::setUnadjustedDate);
			merger.mergeBasic(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ScheduledDateBase _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ScheduledDateBaseBuilder {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"type=" + this.type +
			'}';
		}
	}
}
