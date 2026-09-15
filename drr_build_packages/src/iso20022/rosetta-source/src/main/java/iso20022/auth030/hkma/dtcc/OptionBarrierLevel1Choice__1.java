package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.OptionBarrierLevel1Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice of barrier levels for an option.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionBarrierLevel1Choice__1", builder=OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OptionBarrierLevel1Choice__1", model="iso20022", builder=OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1BuilderImpl.class, version="${project.version}")
public interface OptionBarrierLevel1Choice__1 extends RosettaModelObject {

	OptionBarrierLevel1Choice__1Meta metaData = new OptionBarrierLevel1Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * For a barrier option involving only one barrier level, specifies the predetermined price of an underlier at which the occurrence of a barrier event (e.g. knock-out) is determined.
	 */
	SecuritiesTransactionPrice23Choice__1 getSngl();
	/**
	 * For a barrier option involving two barrier levels, specifies the lower and upper levels as a predetermined price of an underlier at which the occurrence of a barrier event (such as a knock-out) is determined.
	 */
	OptionMultipleBarrierLevels1__1 getMltpl();

	/*********************** Build Methods  ***********************/
	OptionBarrierLevel1Choice__1 build();
	
	OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder toBuilder();
	
	static OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder builder() {
		return new OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionBarrierLevel1Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionBarrierLevel1Choice__1> getType() {
		return OptionBarrierLevel1Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("sngl"), processor, SecuritiesTransactionPrice23Choice__1.class, getSngl());
		processRosetta(path.newSubPath("mltpl"), processor, OptionMultipleBarrierLevels1__1.class, getMltpl());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionBarrierLevel1Choice__1Builder extends OptionBarrierLevel1Choice__1, RosettaModelObjectBuilder {
		SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder getOrCreateSngl();
		@Override
		SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder getSngl();
		OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder getOrCreateMltpl();
		@Override
		OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder getMltpl();
		OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder setSngl(SecuritiesTransactionPrice23Choice__1 sngl);
		OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder setMltpl(OptionMultipleBarrierLevels1__1 mltpl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("sngl"), processor, SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder.class, getSngl());
			processRosetta(path.newSubPath("mltpl"), processor, OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder.class, getMltpl());
		}
		

		OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of OptionBarrierLevel1Choice__1  ***********************/
	class OptionBarrierLevel1Choice__1Impl implements OptionBarrierLevel1Choice__1 {
		private final SecuritiesTransactionPrice23Choice__1 sngl;
		private final OptionMultipleBarrierLevels1__1 mltpl;
		
		protected OptionBarrierLevel1Choice__1Impl(OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder builder) {
			this.sngl = ofNullable(builder.getSngl()).map(f->f.build()).orElse(null);
			this.mltpl = ofNullable(builder.getMltpl()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("sngl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sngl")
		public SecuritiesTransactionPrice23Choice__1 getSngl() {
			return sngl;
		}
		
		@Override
		@RosettaAttribute("mltpl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mltpl")
		public OptionMultipleBarrierLevels1__1 getMltpl() {
			return mltpl;
		}
		
		@Override
		public OptionBarrierLevel1Choice__1 build() {
			return this;
		}
		
		@Override
		public OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder toBuilder() {
			OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder builder) {
			ofNullable(getSngl()).ifPresent(builder::setSngl);
			ofNullable(getMltpl()).ifPresent(builder::setMltpl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionBarrierLevel1Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(sngl, _that.getSngl())) return false;
			if (!Objects.equals(mltpl, _that.getMltpl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sngl != null ? sngl.hashCode() : 0);
			_result = 31 * _result + (mltpl != null ? mltpl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionBarrierLevel1Choice__1 {" +
				"sngl=" + this.sngl + ", " +
				"mltpl=" + this.mltpl +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionBarrierLevel1Choice__1  ***********************/
	class OptionBarrierLevel1Choice__1BuilderImpl implements OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder {
	
		protected SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder sngl;
		protected OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder mltpl;
		
		@Override
		@RosettaAttribute("sngl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sngl")
		public SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder getSngl() {
			return sngl;
		}
		
		@Override
		public SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder getOrCreateSngl() {
			SecuritiesTransactionPrice23Choice__1.SecuritiesTransactionPrice23Choice__1Builder result;
			if (sngl!=null) {
				result = sngl;
			}
			else {
				result = sngl = SecuritiesTransactionPrice23Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mltpl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mltpl")
		public OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder getMltpl() {
			return mltpl;
		}
		
		@Override
		public OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder getOrCreateMltpl() {
			OptionMultipleBarrierLevels1__1.OptionMultipleBarrierLevels1__1Builder result;
			if (mltpl!=null) {
				result = mltpl;
			}
			else {
				result = mltpl = OptionMultipleBarrierLevels1__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("sngl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sngl")
		@Override
		public OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder setSngl(SecuritiesTransactionPrice23Choice__1 _sngl) {
			this.sngl = _sngl == null ? null : _sngl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mltpl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mltpl")
		@Override
		public OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder setMltpl(OptionMultipleBarrierLevels1__1 _mltpl) {
			this.mltpl = _mltpl == null ? null : _mltpl.toBuilder();
			return this;
		}
		
		@Override
		public OptionBarrierLevel1Choice__1 build() {
			return new OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Impl(this);
		}
		
		@Override
		public OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder prune() {
			if (sngl!=null && !sngl.prune().hasData()) sngl = null;
			if (mltpl!=null && !mltpl.prune().hasData()) mltpl = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSngl()!=null && getSngl().hasData()) return true;
			if (getMltpl()!=null && getMltpl().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder o = (OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder) other;
			
			merger.mergeRosetta(getSngl(), o.getSngl(), this::setSngl);
			merger.mergeRosetta(getMltpl(), o.getMltpl(), this::setMltpl);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionBarrierLevel1Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(sngl, _that.getSngl())) return false;
			if (!Objects.equals(mltpl, _that.getMltpl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sngl != null ? sngl.hashCode() : 0);
			_result = 31 * _result + (mltpl != null ? mltpl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionBarrierLevel1Choice__1Builder {" +
				"sngl=" + this.sngl + ", " +
				"mltpl=" + this.mltpl +
			'}';
		}
	}
}
