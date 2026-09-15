package iso20022.dtcc.rds.harmonized;

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
import com.rosetta.model.lib.records.Date;
import iso20022.dtcc.rds.harmonized.meta.CdeSchedule2Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CdeSchedule2", builder=CdeSchedule2.CdeSchedule2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CdeSchedule2", model="iso20022", builder=CdeSchedule2.CdeSchedule2BuilderImpl.class, version="${project.version}")
public interface CdeSchedule2 extends RosettaModelObject {

	CdeSchedule2Meta metaData = new CdeSchedule2Meta();

	/*********************** Getter Methods  ***********************/
	Date getCdeEffectiveDateOfTheNotionalAmountLeg2();
	Date getCdeEndDateOfTheNotionalAmountLeg2();
	BigDecimal getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2();

	/*********************** Build Methods  ***********************/
	CdeSchedule2 build();
	
	CdeSchedule2.CdeSchedule2Builder toBuilder();
	
	static CdeSchedule2.CdeSchedule2Builder builder() {
		return new CdeSchedule2.CdeSchedule2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CdeSchedule2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CdeSchedule2> getType() {
		return CdeSchedule2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cdeEffectiveDateOfTheNotionalAmountLeg2"), Date.class, getCdeEffectiveDateOfTheNotionalAmountLeg2(), this);
		processor.processBasic(path.newSubPath("cdeEndDateOfTheNotionalAmountLeg2"), Date.class, getCdeEndDateOfTheNotionalAmountLeg2(), this);
		processor.processBasic(path.newSubPath("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2"), BigDecimal.class, getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CdeSchedule2Builder extends CdeSchedule2, RosettaModelObjectBuilder {
		CdeSchedule2.CdeSchedule2Builder setCdeEffectiveDateOfTheNotionalAmountLeg2(Date cdeEffectiveDateOfTheNotionalAmountLeg2);
		CdeSchedule2.CdeSchedule2Builder setCdeEndDateOfTheNotionalAmountLeg2(Date cdeEndDateOfTheNotionalAmountLeg2);
		CdeSchedule2.CdeSchedule2Builder setCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2(BigDecimal cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cdeEffectiveDateOfTheNotionalAmountLeg2"), Date.class, getCdeEffectiveDateOfTheNotionalAmountLeg2(), this);
			processor.processBasic(path.newSubPath("cdeEndDateOfTheNotionalAmountLeg2"), Date.class, getCdeEndDateOfTheNotionalAmountLeg2(), this);
			processor.processBasic(path.newSubPath("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2"), BigDecimal.class, getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2(), this);
		}
		

		CdeSchedule2.CdeSchedule2Builder prune();
	}

	/*********************** Immutable Implementation of CdeSchedule2  ***********************/
	class CdeSchedule2Impl implements CdeSchedule2 {
		private final Date cdeEffectiveDateOfTheNotionalAmountLeg2;
		private final Date cdeEndDateOfTheNotionalAmountLeg2;
		private final BigDecimal cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2;
		
		protected CdeSchedule2Impl(CdeSchedule2.CdeSchedule2Builder builder) {
			this.cdeEffectiveDateOfTheNotionalAmountLeg2 = builder.getCdeEffectiveDateOfTheNotionalAmountLeg2();
			this.cdeEndDateOfTheNotionalAmountLeg2 = builder.getCdeEndDateOfTheNotionalAmountLeg2();
			this.cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2 = builder.getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2();
		}
		
		@Override
		@RosettaAttribute("cdeEffectiveDateOfTheNotionalAmountLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeEffectiveDateOfTheNotionalAmountLeg2")
		public Date getCdeEffectiveDateOfTheNotionalAmountLeg2() {
			return cdeEffectiveDateOfTheNotionalAmountLeg2;
		}
		
		@Override
		@RosettaAttribute("cdeEndDateOfTheNotionalAmountLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeEndDateOfTheNotionalAmountLeg2")
		public Date getCdeEndDateOfTheNotionalAmountLeg2() {
			return cdeEndDateOfTheNotionalAmountLeg2;
		}
		
		@Override
		@RosettaAttribute("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2")
		public BigDecimal getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2() {
			return cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2;
		}
		
		@Override
		public CdeSchedule2 build() {
			return this;
		}
		
		@Override
		public CdeSchedule2.CdeSchedule2Builder toBuilder() {
			CdeSchedule2.CdeSchedule2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CdeSchedule2.CdeSchedule2Builder builder) {
			ofNullable(getCdeEffectiveDateOfTheNotionalAmountLeg2()).ifPresent(builder::setCdeEffectiveDateOfTheNotionalAmountLeg2);
			ofNullable(getCdeEndDateOfTheNotionalAmountLeg2()).ifPresent(builder::setCdeEndDateOfTheNotionalAmountLeg2);
			ofNullable(getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2()).ifPresent(builder::setCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CdeSchedule2 _that = getType().cast(o);
		
			if (!Objects.equals(cdeEffectiveDateOfTheNotionalAmountLeg2, _that.getCdeEffectiveDateOfTheNotionalAmountLeg2())) return false;
			if (!Objects.equals(cdeEndDateOfTheNotionalAmountLeg2, _that.getCdeEndDateOfTheNotionalAmountLeg2())) return false;
			if (!Objects.equals(cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2, _that.getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cdeEffectiveDateOfTheNotionalAmountLeg2 != null ? cdeEffectiveDateOfTheNotionalAmountLeg2.hashCode() : 0);
			_result = 31 * _result + (cdeEndDateOfTheNotionalAmountLeg2 != null ? cdeEndDateOfTheNotionalAmountLeg2.hashCode() : 0);
			_result = 31 * _result + (cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2 != null ? cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CdeSchedule2 {" +
				"cdeEffectiveDateOfTheNotionalAmountLeg2=" + this.cdeEffectiveDateOfTheNotionalAmountLeg2 + ", " +
				"cdeEndDateOfTheNotionalAmountLeg2=" + this.cdeEndDateOfTheNotionalAmountLeg2 + ", " +
				"cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2=" + this.cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2 +
			'}';
		}
	}

	/*********************** Builder Implementation of CdeSchedule2  ***********************/
	class CdeSchedule2BuilderImpl implements CdeSchedule2.CdeSchedule2Builder {
	
		protected Date cdeEffectiveDateOfTheNotionalAmountLeg2;
		protected Date cdeEndDateOfTheNotionalAmountLeg2;
		protected BigDecimal cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2;
		
		@Override
		@RosettaAttribute("cdeEffectiveDateOfTheNotionalAmountLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeEffectiveDateOfTheNotionalAmountLeg2")
		public Date getCdeEffectiveDateOfTheNotionalAmountLeg2() {
			return cdeEffectiveDateOfTheNotionalAmountLeg2;
		}
		
		@Override
		@RosettaAttribute("cdeEndDateOfTheNotionalAmountLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeEndDateOfTheNotionalAmountLeg2")
		public Date getCdeEndDateOfTheNotionalAmountLeg2() {
			return cdeEndDateOfTheNotionalAmountLeg2;
		}
		
		@Override
		@RosettaAttribute("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2")
		public BigDecimal getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2() {
			return cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2;
		}
		
		@RosettaAttribute("cdeEffectiveDateOfTheNotionalAmountLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdeEffectiveDateOfTheNotionalAmountLeg2")
		@Override
		public CdeSchedule2.CdeSchedule2Builder setCdeEffectiveDateOfTheNotionalAmountLeg2(Date _cdeEffectiveDateOfTheNotionalAmountLeg2) {
			this.cdeEffectiveDateOfTheNotionalAmountLeg2 = _cdeEffectiveDateOfTheNotionalAmountLeg2 == null ? null : _cdeEffectiveDateOfTheNotionalAmountLeg2;
			return this;
		}
		
		@RosettaAttribute("cdeEndDateOfTheNotionalAmountLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdeEndDateOfTheNotionalAmountLeg2")
		@Override
		public CdeSchedule2.CdeSchedule2Builder setCdeEndDateOfTheNotionalAmountLeg2(Date _cdeEndDateOfTheNotionalAmountLeg2) {
			this.cdeEndDateOfTheNotionalAmountLeg2 = _cdeEndDateOfTheNotionalAmountLeg2 == null ? null : _cdeEndDateOfTheNotionalAmountLeg2;
			return this;
		}
		
		@RosettaAttribute("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2")
		@Override
		public CdeSchedule2.CdeSchedule2Builder setCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2(BigDecimal _cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2) {
			this.cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2 = _cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2 == null ? null : _cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2;
			return this;
		}
		
		@Override
		public CdeSchedule2 build() {
			return new CdeSchedule2.CdeSchedule2Impl(this);
		}
		
		@Override
		public CdeSchedule2.CdeSchedule2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CdeSchedule2.CdeSchedule2Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCdeEffectiveDateOfTheNotionalAmountLeg2()!=null) return true;
			if (getCdeEndDateOfTheNotionalAmountLeg2()!=null) return true;
			if (getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CdeSchedule2.CdeSchedule2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CdeSchedule2.CdeSchedule2Builder o = (CdeSchedule2.CdeSchedule2Builder) other;
			
			
			merger.mergeBasic(getCdeEffectiveDateOfTheNotionalAmountLeg2(), o.getCdeEffectiveDateOfTheNotionalAmountLeg2(), this::setCdeEffectiveDateOfTheNotionalAmountLeg2);
			merger.mergeBasic(getCdeEndDateOfTheNotionalAmountLeg2(), o.getCdeEndDateOfTheNotionalAmountLeg2(), this::setCdeEndDateOfTheNotionalAmountLeg2);
			merger.mergeBasic(getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2(), o.getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2(), this::setCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CdeSchedule2 _that = getType().cast(o);
		
			if (!Objects.equals(cdeEffectiveDateOfTheNotionalAmountLeg2, _that.getCdeEffectiveDateOfTheNotionalAmountLeg2())) return false;
			if (!Objects.equals(cdeEndDateOfTheNotionalAmountLeg2, _that.getCdeEndDateOfTheNotionalAmountLeg2())) return false;
			if (!Objects.equals(cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2, _that.getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cdeEffectiveDateOfTheNotionalAmountLeg2 != null ? cdeEffectiveDateOfTheNotionalAmountLeg2.hashCode() : 0);
			_result = 31 * _result + (cdeEndDateOfTheNotionalAmountLeg2 != null ? cdeEndDateOfTheNotionalAmountLeg2.hashCode() : 0);
			_result = 31 * _result + (cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2 != null ? cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CdeSchedule2Builder {" +
				"cdeEffectiveDateOfTheNotionalAmountLeg2=" + this.cdeEffectiveDateOfTheNotionalAmountLeg2 + ", " +
				"cdeEndDateOfTheNotionalAmountLeg2=" + this.cdeEndDateOfTheNotionalAmountLeg2 + ", " +
				"cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2=" + this.cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg2 +
			'}';
		}
	}
}
